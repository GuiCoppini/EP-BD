package SistemadeOcorrencias.Ocorrencia

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OcorrenciaRepository : JpaRepository<Ocorrencia, Long> {

}