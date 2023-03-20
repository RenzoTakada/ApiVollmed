package med.ApiMed.Controller;

import med.ApiMed.Domain.DTO.DTOlistagemMedico;
import med.ApiMed.Infra.SQlServer.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medico/lista")
public class ListaMedicoController {

    @Autowired
    private MedicoRepository repository;
    @GetMapping
    public ResponseEntity<Page<DTOlistagemMedico>> listaDeMedico(@PageableDefault(size =20) Pageable page){
        return ResponseEntity.ok( repository.findAllByAtivaTrue(page).map(DTOlistagemMedico::new));
    }

}
