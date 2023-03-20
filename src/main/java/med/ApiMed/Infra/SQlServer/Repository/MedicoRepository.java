package med.ApiMed.Infra.SQlServer.Repository;

import io.micrometer.observation.ObservationFilter;
import med.ApiMed.Infra.SQlServer.Models.EntidadeJPAMedico;
import org.springframework.beans.PropertyValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<EntidadeJPAMedico,Long> {
    Page<EntidadeJPAMedico>  findAllByAtivaTrue(Pageable page);
}
