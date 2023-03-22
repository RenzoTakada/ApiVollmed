package med.ApiMed.Controller.Autenticacao;

import jakarta.validation.Valid;
import med.ApiMed.Domain.DTO.DTODadosTokenJWT;
import med.ApiMed.Domain.DTO.DTOdadosLogin;
import med.ApiMed.Infra.SQlServer.Entities.EntitadeJPAusuario;
import med.ApiMed.Infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager maneger;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DTOdadosLogin request){
        var autenticationToken = new UsernamePasswordAuthenticationToken(request.login(),request.senha());
        var authentication =  maneger.authenticate(autenticationToken);
        var tokenJWT = tokenService.gerarToken((EntitadeJPAusuario) authentication.getPrincipal());
        return  ResponseEntity.ok(new DTODadosTokenJWT(tokenJWT));
    }
}

