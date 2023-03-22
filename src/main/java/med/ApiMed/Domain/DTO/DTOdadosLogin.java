package med.ApiMed.Domain.DTO;

import jakarta.validation.constraints.NotBlank;

public record DTOdadosLogin (
        @NotBlank
        String login,
        @NotBlank
        String senha){
}
