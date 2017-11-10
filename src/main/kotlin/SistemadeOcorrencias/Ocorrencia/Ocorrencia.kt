package SistemadeOcorrencias.Ocorrencia

import javax.persistence.*


@Entity
@Table(name="OCORRENCIAS")
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

    @ManyToMany(targetEntity=Funcionario::class, cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "ALTEROU_OCORRENCIA",
            joinColumns = arrayOf(JoinColumn(name = "id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "cpf"))
    )
    private var funcionarios: Set<Funcionario> = mutableSetOf()
}