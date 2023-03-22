package med.ApiMed.Domain.Mapping;

import med.ApiMed.Domain.DTO.DtoDadosCadastroMedico;
import med.ApiMed.Infra.SQlServer.Entities.EntidadeJPAEndereco;
import med.ApiMed.Infra.SQlServer.Entities.EntidadeJPAMedico;
import org.springframework.stereotype.Component;


@Component
public  class MappingRequestToRepository {
    public  EntidadeJPAMedico RequestTOEntiteMedico(DtoDadosCadastroMedico request) {
        var endereco = new EntidadeJPAEndereco(request.endereco().logradouro(),request.endereco().bairro(),request.endereco().cep(),request.endereco().numero(),request.endereco().complemento(),request.endereco().cidade(),request.endereco().uf());
        return  new EntidadeJPAMedico(request.nome(),request.email(),request.telefone(),request.crm(),request.especialidade(),endereco);
    }

}
