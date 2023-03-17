package med.ApiMed.Infra.SQlServer.Repository;

import med.ApiMed.Infra.SQlServer.Models.EntidadeJPAMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<EntidadeJPAMedico,Long> {//primeiro vem a entidade que o jpa vai trabalhar, depois vem o id


}
