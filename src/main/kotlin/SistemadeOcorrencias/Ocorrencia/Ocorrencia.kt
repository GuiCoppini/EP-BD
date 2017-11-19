package SistemadeOcorrencias.Ocorrencia

import javax.persistence.*
import kotlin.jvm.Transient


@Entity
@Table(name="OCORRENCIA")
class Ocorrencia(
                 @Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
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

@ManyToMany(mappedBy = "ocorrencias")
//@ManyToMany(fetch = FetchType.EAGER, cascade = arrayOf(
//        CascadeType.ALL)
//)
//    @JoinTable(name = "ALTEROU_OCORRENCIA",
//            joinColumns = arrayOf(JoinColumn(name = "id_oc")),
//            inverseJoinColumns = arrayOf(JoinColumn(name = "id_func"))
//    )
    private var funcionarios: MutableSet<Funcionario> = mutableSetOf()

    fun getFuncionarios() = funcionarios
}