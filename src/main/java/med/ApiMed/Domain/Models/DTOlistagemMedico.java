package med.ApiMed.Domain.Models;

import med.ApiMed.Domain.Enum.Enum.EnumEspecialidade;
import med.ApiMed.Infra.SQlServer.Models.EntidadeJPAMedico;

public record  DTOlistagemMedico (String nome, String Email, String crm, EnumEspecialidade especialidade){


    public DTOlistagemMedico(EntidadeJPAMedico responseRepository) {
        this(responseRepository.getNome(),responseRepository.getEmail(),responseRepository.getCrm(),responseRepository.getEspecialidade());
    }
}
