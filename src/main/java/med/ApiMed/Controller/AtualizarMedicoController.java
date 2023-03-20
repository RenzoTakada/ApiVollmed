package med.ApiMed.Controller;
import med.ApiMed.Domain.DTO.DTODadosDetalhamentoMedico;
import med.ApiMed.Domain.DTO.DtoDadosAtualizarMedico;
import med.ApiMed.Infra.SQlServer.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medico/atualizar")
public class AtualizarMedicoController {

    @Autowired
    private MedicoRepository repository;
    @PutMapping
    @Transactional
    public ResponseEntity atualizando(@RequestBody  DtoDadosAtualizarMedico request){
        var medico = repository.getReferenceById(request.id());
        try {
            medico.AtualizarInformacoes(request);
            return ResponseEntity.ok( new DTODadosDetalhamentoMedico(medico));
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao Atualizar Usuario " + medico.getNome().toString()) ;
        }
    }
}
