package SistemadeOcorrencias.Ocorrencia

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Ocorrencia(
        @Id
        @GeneratedValue
        var id : Long? = null,
        var descricao : String,
        var prioridade : Int
) {

    var horario : Date? = null
    var medidas : String? = null

    constructor() : this(descricao = "",
                         prioridade = -1)

}