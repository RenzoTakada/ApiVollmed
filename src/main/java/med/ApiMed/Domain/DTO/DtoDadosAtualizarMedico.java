package med.ApiMed.Domain.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.ApiMed.Domain.Enum.EnumEspecialidade;

public record DtoDadosAtualizarMedico (

        @NotBlank
        Long id,
        @NotBlank//valida se não é nulo ou vazio
        String nome,
        String email,
        @NotBlank
        String telefone,
        String crm,
        EnumEspecialidade especialidade,
        DtoEndereco endereco
){
}
