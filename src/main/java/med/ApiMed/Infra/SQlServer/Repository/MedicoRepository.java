package med.ApiMed.Infra.SQlServer.Repository;

import med.ApiMed.Infra.SQlServer.Entities.EntidadeJPAMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<EntidadeJPAMedico,Long> {
    Page<EntidadeJPAMedico>  findAllByAtivaTrue(Pageable page);
}
