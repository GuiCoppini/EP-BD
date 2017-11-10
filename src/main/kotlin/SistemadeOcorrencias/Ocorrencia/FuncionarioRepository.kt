package SistemadeOcorrencias.Ocorrencia

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepository : JpaRepository<Funcionario, Long> {

    fun findByCpf(cpf: Long?) : Funcionario?

}