package SistemadeOcorrencias.Ocorrencia

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

                 var ultimoUpdate: Date = Date(),

                 var medidas: String? = null)