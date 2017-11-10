package SistemadeOcorrencias.Ocorrencia

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepository : JpaRepository<Ocorrencia, Long> {

    fun findByCpf() : Funcionario?

}