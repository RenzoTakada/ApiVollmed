package med.ApiMed.Domain.Models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.ApiMed.Domain.Enum.Enum.EnumEspecialidade;

public record DtoDadosCadastroMedico(

        @NotBlank//valida se não é nulo ou vazio
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        EnumEspecialidade especialidade,
        @NotNull
        @Valid
        DtoEndereco endereco
) {


}
