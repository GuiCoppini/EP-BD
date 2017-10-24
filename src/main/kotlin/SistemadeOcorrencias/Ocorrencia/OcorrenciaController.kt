package SistemadeOcorrencias.Ocorrencia

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import javax.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*
import java.text.SimpleDateFormat
import java.text.DateFormat
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional


@Controller
class OcorrenciaController {

    @Autowired
    lateinit var ocorrenciaRepository : OcorrenciaRepository

    @PersistenceContext
    lateinit var em : EntityManager

    @RequestMapping("/") // Pagina HOME das ocorrencias
    fun homepage() : ModelAndView {
        val mv = ModelAndView("/homepage")
        return mv
    }

    @RequestMapping("/index") // Mostra todas as ocorrencias
    fun todas() : ModelAndView {
        val mv = ModelAndView("lista_de_ocorrencias")
        mv.addObject("ocorrencias", ocorrenciaRepository.findAll())

        return mv
    }

    @RequestMapping("/{id}/editar") // Edita a Ocorrecia com esse id
    fun editar(@PathVariable("id") id: Long) : ModelAndView {

        return novaOcorrencia(ocorrenciaRepository.findOne(id))
    }

    @RequestMapping("/{id}/excluir") // Excluir a Ocorrecia com esse id
    fun excluir(@PathVariable("id") id: Long) : ModelAndView {

        ocorrenciaRepository.delete(id)

        return ModelAndView("redirect:/index")

    }

    @RequestMapping("/nova-ocorrencia") // Form de criar ocorrencia
    fun novaOcorrencia(ocorrencia : Ocorrencia) : ModelAndView {
        val mv = ModelAndView("/form_ocorrencia")
        mv.addObject("ocorrencia", ocorrencia)

        return mv
    }

    @PostMapping("/salvar")
    fun salva(@Valid oc: Ocorrencia, result: BindingResult): ModelAndView {

        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        
        ocorrenciaRepository.saveAndFlush(oc)
        return ModelAndView("redirect:/index")

    }
}