package med.ApiMed.Domain.Models;

import med.ApiMed.Domain.Models.Enum.EnumEspecialidade;

public record DtoDadosCadastroMedico(String nome, String email, String crm, EnumEspecialidade especialidade,DtoEndereco endereco) {


}
