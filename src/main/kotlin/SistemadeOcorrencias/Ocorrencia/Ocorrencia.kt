package SistemadeOcorrencias.Ocorrencia

import SistemadeOcorrencias.Funcionario.Funcionario
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import javax.persistence.*
import javax.security.auth.Subject


@Entity
@Table(name="OCORRENCIA")
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
) {

    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "ALTEROU_OCORRENCIA",
            joinColumns = arrayOf(JoinColumn(name = "funcionario_cpf", referencedColumnName = "cpf")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "ocorrencia_id", referencedColumnName = "id"))
    )
    val funcionarios: Set<Funcionario> = mutableSetOf()
}