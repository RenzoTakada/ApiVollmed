package med.ApiMed.Infra.SQlServer.Models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
//    public EntidadeJPAEndereco(String lagradouro, String bairro,String cep, String numero,String complemento,String cidade,String uf){
//        this.lagradouro = lagradouro;
//        this.bairro = bairro;
//        this.cep = cep;
//        this.numero = numero;
//        this.complemento = complemento;
//        this.cidade = cidade;
//        this.uf = uf;
//    }
}
