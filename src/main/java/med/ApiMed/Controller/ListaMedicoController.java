package med.ApiMed.Controller;

import med.ApiMed.Domain.Models.DTOlistagemMedico;
import med.ApiMed.Infra.SQlServer.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("lista/medico")
public class ListaMedicoController {

    @Autowired
    private MedicoRepository repository;
    @GetMapping
    public List<DTOlistagemMedico> listaDeMedico(){
        return repository.findAll().stream().map(DTOlistagemMedico::new).toList();
    }

}
