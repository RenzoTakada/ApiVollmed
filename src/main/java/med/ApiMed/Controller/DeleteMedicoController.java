package med.ApiMed.Controller;

import med.ApiMed.Infra.SQlServer.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medico/deletar")
public class DeleteMedicoController {

    @Autowired
    private MedicoRepository repository;
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeletandoUsuario (@PathVariable long id){
        var medico = repository.getReferenceById(id);
        medico.ExclusaoLogica();
        return ResponseEntity.ok( "Usuario "+medico.getNome() +" Excluido com sucesso");
    }
}
