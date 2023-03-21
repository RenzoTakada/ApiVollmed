package med.ApiMed.Infra.SQlServer.Repository;

import med.ApiMed.Infra.SQlServer.Models.EntitadeJPAusuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface usuarioRepository extends JpaRepository<EntitadeJPAusuario,Long> {
    UserDetails findBylogin(String login);
}
