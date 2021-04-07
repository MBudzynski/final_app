package pl.sda.finalapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller()
public class RegisterUserController {

    @Autowired
    private RegistrationValidator registrationValidator;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    String registerForm(Model model){
        model.addAttribute("registrationUserDto", new RegistrationUserDto());
        model.addAttribute("countryList", Country.values());
        return "registerPage";
    }

    @PostMapping("/register")
    String registerUser(@ModelAttribute RegistrationUserDto registrationUserDto, Model model){
        Map<String, String> errorMap = registrationValidator.isValid(registrationUserDto);
        if(errorMap.isEmpty()){
            try {
                userService.registerUser(registrationUserDto);
            } catch (UserExistsExeption e) {
                model.addAttribute("registrationUserDto", registrationUserDto);
                model.addAttribute("countryList", Country.values());
                model.addAttribute("userFoundMessage", e.getMessage());
                return "registerPage";

            }
            return "index";
        }
        model.addAttribute("registrationUserDto", registrationUserDto);
        model.addAttribute("countryList", Country.values());
        model.addAllAttributes(errorMap);
        return "registerPage";
    }
}
