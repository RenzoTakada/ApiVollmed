package med.ApiMed.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("olamundo")
public class HelloController {

    @GetMapping
    public String olaMundo(){
        return "Hello Word renzo";
    }
}
