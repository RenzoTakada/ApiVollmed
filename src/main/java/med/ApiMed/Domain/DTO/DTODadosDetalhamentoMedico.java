package med.ApiMed.Domain.DTO;

import med.ApiMed.Domain.Enum.EnumEspecialidade;
import med.ApiMed.Infra.SQlServer.Models.EntidadeJPAEndereco;
import med.ApiMed.Infra.SQlServer.Models.EntidadeJPAMedico;

public record DTODadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, EnumEspecialidade especialidade, EntidadeJPAEndereco endereco) {
    public DTODadosDetalhamentoMedico (EntidadeJPAMedico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}