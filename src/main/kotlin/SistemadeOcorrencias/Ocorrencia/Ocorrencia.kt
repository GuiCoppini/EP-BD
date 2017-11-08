package SistemadeOcorrencias.Ocorrencia

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.util.Date
import javax.persistence.Table
import javax.persistence.Column

@Entity
@Table(name="Ocorrencias")
class Ocorrencia(
                 @Id
                 @GeneratedValue
                 var id: Long? = null,

                 @Column(name="Descricao")
                 var descricao: String? = null,

                 @Column(name="Prioridade")
                 var prioridade: Int = 0,

                 @Column(name="Data_de_update")
                 var ultimoUpdate: String = "",

                 @Column(name="Medidas")
                 var medidas: String = "Esta ocorrencia ainda não foi tratada!",

                 @Column(name="Data_de_criacao")
                 var criacao : String = ""
)