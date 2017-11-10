package SistemadeOcorrencias.Ocorrencia

import javax.persistence.*


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
                 var criacao : String = ""
) {

    @ManyToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    @JoinTable(name = "ALTEROU_OCORRENCIA",
            joinColumns = arrayOf(JoinColumn(name = "id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "cpf"))
    )
    private var funcionarios: List<Funcionario> = mutableListOf()
}