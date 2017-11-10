package SistemadeOcorrencias.Ocorrencia

import java.util.Date
import javax.persistence.*
import javax.persistence.FetchType



@Entity
@Table(name="FUNCIONARIO")
class Funcionario(
        @Id
        @Column(name="cpf") // unico campo que vamos usar de fato
        var cpf: Long? = null,

        @Column(name="rg")
        var rg: String? = null,

        @Column(name="salario")
        var salario: Double? = null,

        @Column(name="horas_de_trabalho")
        var horasDeTrabalho: Int = 0,

        @Column(name="nome")
        var nome: String = "",

        @Column(name="data_nascimento")
        var dataNascimento: Date? = null,
        

        @Column(name="email")
        var email : String = ""
) {
    @ManyToMany(mappedBy = "funcionarios", fetch  = FetchType.LAZY)
    private var ocorrencias : List<Ocorrencia> = mutableListOf()
}