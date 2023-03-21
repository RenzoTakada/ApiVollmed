package med.ApiMed.Infra.SQlServer.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "EntitadeJPAusuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EntitadeJPAusuario {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String login;
private String senha;
}
