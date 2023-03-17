package med.ApiMed.Infra.SQlServer.Models;

import jakarta.persistence.*;
import lombok.*;
import med.ApiMed.Domain.Enum.Enum.EnumEspecialidade;
import med.ApiMed.Domain.Models.DtoEndereco;

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
    @Embedded //serve para dizer que a entidade endereço esta em uma classe separada
    private EntidadeJPAEndereco Endereco;
    public EntidadeJPAMedico(String nome,String email,String telefone, String crm,EnumEspecialidade especialidade, EntidadeJPAEndereco endereco){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
        this.Endereco = endereco;
    }
}
