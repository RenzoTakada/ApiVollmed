package med.ApiMed.Infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.ApiMed.Infra.SQlServer.Repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class securityJWTFilter extends OncePerRequestFilter {

    @Autowired
    private usuarioRepository repository;
    @Autowired
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
           var tokenJWT = recuperaToken(request);
           if(tokenJWT!=null){
               var subject = tokenService.getSubject(tokenJWT);
               var usuario = repository.findBylogin(subject);
               var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
           }
            filterChain.doFilter(request,response);
    }

    private String recuperaToken(HttpServletRequest request) {
         var authorizationHeader = request.getHeader("Authorization");
         if(authorizationHeader!=null){
             return authorizationHeader.replace("Bearer ","");
         }
        return null;
    }
}
