package SistemadeOcorrencias.Ocorrencia

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import java.text.SimpleDateFormat
import java.util.*
import javax.validation.Valid


@Controller
class OcorrenciaController {

    @Autowired
    lateinit var ocorrenciaRepository : OcorrenciaRepository

    @Autowired
    lateinit var funcionarioRepository: FuncionarioRepository

    @RequestMapping("/") // Pagina HOME das ocorrencias
    fun homepage() : ModelAndView {
        val mv = ModelAndView("homepage")

        return mv
    }

    @RequestMapping("/{id}/funcionarios") // Pagina HOME das ocorrencias
    fun funcionariosDaOcorrencia(@PathVariable("id") id: Long) : ModelAndView {
        val mv = ModelAndView("lista_de_funcionarios")

        mv.addObject("funcionarios", ocorrenciaRepository.findOne(id).getFuncionarios())

        return mv
    }

    @RequestMapping("/funcionario/{cpf}") // Pagina HOME das ocorrencias
    fun ocorrenciasDoFuncionario(@PathVariable("cpf") cpf: Long) : ModelAndView {
        val mv = ModelAndView("ocorrencias_do_funcionario")

        val funcionario = funcionarioRepository.findByCpf(cpf)
        if (funcionario != null) {

            mv.addObject("funcionario", funcionario)
            mv.addObject("ocorrencias", funcionario.getOcorrencias())
            return mv
        } else {
            return ModelAndView("funcionario_nao_encontrado")
        }

    }



    @RequestMapping("/index") // Mostra todas as ocorrencias
    fun todas(@RequestParam("tipo") tipo : String,
              @RequestParam("attr", required = false) attr : String?) : ModelAndView {
        val mv = ModelAndView("lista_de_ocorrencias")
        var list : List<Ocorrencia>? = null

        if(attr != null) {
            when(tipo) {
                "all" -> list = ocorrenciaRepository.busca(attr)
            }
        } else {
            when (tipo) {
                "all" -> list = ocorrenciaRepository.findAll()
                "prioridade" -> list = ocorrenciaRepository.findAllByOrderByPrioridadeDesc()
                "id" -> list = ocorrenciaRepository.findAllByOrderByIdAsc()
                "update" -> list = ocorrenciaRepository.findAllByOrderByUltimoUpdateDesc()
                "tratadas" -> list = ocorrenciaRepository.findAll().filter { it -> it.medidas != "Esta ocorrencia ainda não foi tratada!" }
                "pendentes" -> list = ocorrenciaRepository.findAll().filter { it -> it.medidas == "Esta ocorrencia ainda não foi tratada!" }
            }
        }


        mv.addObject("ocorrencias", list)

        return mv
    }

    @RequestMapping("/{id}/editar") // Edita a Ocorrecia com esse id
    fun editar(@PathVariable("id") id: Long?) : ModelAndView {

        return novaOcorrencia(ocorrenciaRepository.findOne(id))
    }

    @RequestMapping("/{id}") // Mostra a ocorrencia, seus detalhes e suas opcoes
    fun mostraUma(@PathVariable("id") id: Long) : ModelAndView {

        val mv = ModelAndView("ocorrencia")
        mv.addObject("oc", ocorrenciaRepository.findOne(id))

        return mv
    }


    @RequestMapping("/{id}/excluir") // Excluir a Ocorrecia com esse id
    fun excluir(@PathVariable("id") id: Long) : ModelAndView {

        ocorrenciaRepository.delete(id)

        return ModelAndView("redirect:/index?tipo=all")

    }

    @RequestMapping("/{id}/resolver")
    fun resolve(@PathVariable("id") id: Long): ModelAndView {

        val mv = ModelAndView("resolvendo")

        mv.addObject(ocorrenciaRepository.findOne(id))

        return mv

    }

    @RequestMapping("/nova-ocorrencia") // Form de criar ocorrencia
    fun novaOcorrencia(ocorrencia : Ocorrencia) : ModelAndView {
        val mv = ModelAndView("form_ocorrencia")
        mv.addObject("ocorrencia", ocorrencia)

        return mv
    }

    @PostMapping("/salvar")
    fun salva(@Valid oc: Ocorrencia, result: BindingResult): ModelAndView {

        val funcionario = funcionarioRepository.findByCpf(oc.cpfTemporario)

        if(funcionario == null) {
            return ModelAndView("funcionario_nao_encontrado")
        }

        oc.getFuncionarios().add(funcionario) // add funcionario na ocorrencia
        funcionario.getOcorrencias().add(oc) // add ocorrencia no funcionario

        funcionarioRepository.saveAndFlush(funcionario)


        if(oc.criacao == "") oc.criacao = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Date())

        oc.ultimoUpdate = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Date())

        ocorrenciaRepository.saveAndFlush(oc)
        return ModelAndView("redirect:/index?tipo=all")

    }
}