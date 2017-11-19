package SistemadeOcorrencias.Ocorrencia

import java.util.Date
import javax.persistence.*
import javax.persistence.FetchType



@Entity
@Table(name="FUNCIONARIO")
class Funcionario(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id") // unico campo que vamos usar de fato
        var id: Long? = null,

        @Column(name="cpf") // unico campo que vamos usar de fato
        var cpf: Long? = null,

        @Column(name="rg")
        var rg: String? = null,

        @Column(name="salario")
        var salario: Double? = null,

        @Column(name="horas_trabalho")
        var horasDeTrabalho: Int = 0,

        @Column(name="nome")
        var nome: String = "",

        @Column(name="data_nascimento")
        var dataNascimento: Date? = null,

        @Column(name="email")
        var email : String = "",

        @Column(name="GER_id")
        var gerenteDoFuncionario : Long? = null
) {
    @ManyToMany(mappedBy = "funcionarios")
    private var ocorrencias : MutableSet<Ocorrencia> = mutableSetOf()

    fun getOcorrencias() = ocorrencias
}