package med.ApiMed.Controller;

import med.ApiMed.Domain.DTO.DTODadosDetalhamentoMedico;
import med.ApiMed.Infra.SQlServer.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medico/consulta")
public class ConsultaMedicoController {

    @Autowired
    private MedicoRepository repository;
    @GetMapping("/{id}")
    public ResponseEntity consulta(@PathVariable long id){
        var ret = repository.getReferenceById(id);
        var med =  new DTODadosDetalhamentoMedico(ret);
        return ResponseEntity.ok(med);
    }

}
