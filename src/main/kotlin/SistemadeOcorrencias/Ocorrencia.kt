//package SistemadeOcorrencias
//
//import java.util.*
//import javax.persistence.Entity
//import javax.persistence.GeneratedValue
//import javax.persistence.Id
//
//@Entity
//data class Ocorrencia(
//        val descricao : String,
//        val prioridade : Int,
//        val horario : Date?,
//        var medidas : String
//) {
//
//    @Id
//    @GeneratedValue
//    val id : Long? = null
//
//    constructor() : this(descricao = "",
//                         prioridade = -1,
//                         horario = null,
//                         medidas = "")
//
//}