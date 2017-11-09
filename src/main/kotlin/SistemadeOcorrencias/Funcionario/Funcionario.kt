package SistemadeOcorrencias.Funcionario

import javax.persistence.*

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.util.Date
import javax.persistence.Table
import javax.persistence.Column

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

        @Column(name="Data_de_criacao")
        var criacao : String = ""
)