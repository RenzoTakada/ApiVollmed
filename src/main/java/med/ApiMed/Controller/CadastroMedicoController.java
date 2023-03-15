package med.ApiMed.Controller;

import med.ApiMed.Domain.Models.DtoDadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cadastro/medico")
public class CadastroMedicoController {

    @PostMapping
    public String cadastrar(@RequestBody DtoDadosCadastroMedico Json){

        return "nome é "  + Json.nome();

    }

}
