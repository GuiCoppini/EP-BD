package SistemadeOcorrencias.Ocorrencia

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface OcorrenciaRepository : JpaRepository<Ocorrencia, Long> {
    fun findAllByOrderByPrioridadeDesc(): List<Ocorrencia>

    fun findAllByOrderByUltimoUpdateDesc(): List<Ocorrencia>

    fun findAllByOrderByIdAsc(): List<Ocorrencia>

    @Query("SELECT o FROM Ocorrencia o WHERE o.descricao LIKE %?1%")
    fun busca(desc : String?) : List<Ocorrencia>

}