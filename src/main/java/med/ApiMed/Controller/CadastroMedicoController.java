package med.ApiMed.Controller;

import jakarta.validation.Valid;
import med.ApiMed.Domain.DTO.DTODadosDetalhamentoMedico;
import med.ApiMed.Domain.Mapping.MappingRequestToRepository;
import med.ApiMed.Domain.DTO.DtoDadosCadastroMedico;
import med.ApiMed.Infra.SQlServer.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medico/cadastro")
public class CadastroMedicoController {

    @Autowired
    private MedicoRepository repository;
    @Autowired
    private MappingRequestToRepository map;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DtoDadosCadastroMedico request, UriComponentsBuilder uribuilder) {
        try{
            var mapMedico = map.RequestTOEntiteMedico(request);
            repository.save(mapMedico);
            var uri = uribuilder.path("/medico/consulta/{id}").buildAndExpand(mapMedico.getId()).toUri();
            return ResponseEntity.created(uri).body(new DTODadosDetalhamentoMedico(mapMedico));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body( "Erro ao cadastrar o usuario");
        }
    }

}
