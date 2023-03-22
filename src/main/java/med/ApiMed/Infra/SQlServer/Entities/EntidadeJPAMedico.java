package med.ApiMed.Infra.SQlServer.Entities;

import jakarta.persistence.*;
import lombok.*;
import med.ApiMed.Domain.DTO.DtoDadosAtualizarMedico;
import med.ApiMed.Domain.Enum.EnumContaAtiva;
import med.ApiMed.Domain.Enum.EnumEspecialidade;

@Table(name= "medicos")
@Entity(name = "EntidadeJPAMedico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EntidadeJPAMedico {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private EnumEspecialidade especialidade;
    @Enumerated(EnumType.ORDINAL)
    private EnumContaAtiva ativa;
    @Embedded //serve para dizer que a entidade endereço esta em uma classe separada
    private EntidadeJPAEndereco Endereco;
    public EntidadeJPAMedico(String nome,String email,String telefone, String crm,EnumEspecialidade especialidade, EntidadeJPAEndereco endereco){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
        this.Endereco = endereco;
        this.ativa = EnumContaAtiva.ATIVA;
    }
    public void ExclusaoLogica(){
        this.ativa = EnumContaAtiva.INATIVA;
    }

    public void AtualizarInformacoes(DtoDadosAtualizarMedico request) {
       if (request.nome() != null)  this.nome = request.nome();
       if(request.email() != null) this.email = request.email();
       if(request.telefone() != null) this.telefone = request.telefone();
       if(request.crm() != null) this.crm = request.crm();
       if(request.especialidade() != null) this.especialidade = request.especialidade();
       if (request.endereco() != null)this.Endereco.AtualizarInformacoes(request.endereco());
    }
}
