package med.ApiMed.Domain.DTO;

import med.ApiMed.Domain.Enum.EnumEspecialidade;
import med.ApiMed.Infra.SQlServer.Models.EntidadeJPAMedico;

public record  DTOlistagemMedico (Long id, String nome, String Email, String crm, EnumEspecialidade especialidade){


    public DTOlistagemMedico(EntidadeJPAMedico responseRepository) {
        this(responseRepository.getId(), responseRepository.getNome(),responseRepository.getEmail(),responseRepository.getCrm(),responseRepository.getEspecialidade());
    }
}
