package SistemadeOcorrencias.Ocorrencia

import javax.persistence.*
import kotlin.jvm.Transient


@Entity
@Table(name="OCORRENCIA")
class Ocorrencia(
                 @Id
                 @GeneratedValue
                 @Column(name="id")
                 var id: Long? = null,

                 @Column(name="descricao")
                 var descricao: String? = null,

                 @Column(name="prioridade")
                 var prioridade: Int = 0,

                 @Column(name="data_update")
                 var ultimoUpdate: String = "",

                 @Column(name="medidas")
                 var medidas: String = "Esta ocorrencia ainda não foi tratada!",

                 @Column(name="data_criacao")
                 var criacao : String = "",

                 @Transient
                 var cpfTemporario : Long? = null
) {

    @ManyToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    @JoinTable(name = "ALTEROU_OCORRENCIA",
            joinColumns = arrayOf(JoinColumn(name = "id"))
    )
    private var funcionarios: MutableList<Funcionario> = mutableListOf()

    fun getFuncionarios() = funcionarios
}