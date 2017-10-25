package SistemadeOcorrencias.Ocorrencia

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.util.Date

@Entity
class Ocorrencia(@Id
                 @GeneratedValue
                 var id: Long? = null,

                 var descricao: String? = null,

                 var prioridade: Int = 0,

                 var ultimoUpdate: String = "",

                 var medidas: String = "Esta ocorrencia ainda não foi tratada!",

                 var criacao : String = ""
)