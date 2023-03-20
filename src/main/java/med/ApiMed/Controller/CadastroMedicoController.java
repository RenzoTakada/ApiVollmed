package med.ApiMed.Controller;

import jakarta.validation.Valid;
import med.ApiMed.Domain.Mapping.MappingRequestToRepository;
import med.ApiMed.Domain.DTO.DtoDadosCadastroMedico;
import med.ApiMed.Infra.SQlServer.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medico/cadastro")
public class CadastroMedicoController {

    @Autowired
    private MedicoRepository repository;
    @Autowired
    private MappingRequestToRepository map;
    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid DtoDadosCadastroMedico request) {
        try{
            var mapObject = map.RequestTOEntiteMedico(request);
            repository.save(mapObject);
            return "Usuario cadastrado com Sucesso";
        }catch (Exception ex){
            return "Erro ao cadastrar o usuario";
        }
    }

}
