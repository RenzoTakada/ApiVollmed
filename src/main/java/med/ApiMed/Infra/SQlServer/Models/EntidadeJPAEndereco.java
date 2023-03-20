package med.ApiMed.Infra.SQlServer.Models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.ApiMed.Domain.DTO.DtoEndereco;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadeJPAEndereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public void AtualizarInformacoes(DtoEndereco endereco){
        if(endereco.logradouro() != null)this.logradouro = endereco.logradouro();
        if(endereco.bairro() != null)this.bairro = endereco.bairro();
        if(endereco.cep() != null) this.cep = endereco.cep();
        if(endereco.numero() != null)this.numero = endereco.numero();
        if(endereco.complemento() != null)this.complemento = endereco.complemento();
        if(endereco.cidade() != null)this.cidade = endereco.cidade();
        if(endereco.uf() != null)this.uf = endereco.cidade();
    }
}
