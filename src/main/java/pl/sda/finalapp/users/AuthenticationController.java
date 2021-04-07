package pl.sda.finalapp.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String displayLoginPage(){
        return "login";
    }

}
