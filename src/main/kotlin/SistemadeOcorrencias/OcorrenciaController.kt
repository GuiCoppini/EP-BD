package SistemadeOcorrencias

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class OcorrenciaController {

    @RequestMapping("/") // Pagina HOME das ocorrencias
    fun homepage() : ModelAndView {
        val mv = ModelAndView("/homepage")
        return mv
    }
}