package pl.sda.finalapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Text;

@Controller
public class SampleController {
    @Autowired
    private TextProvider helloTextService;
    @Autowired
    private TextProvider welcomeTextService;
    @Autowired
    private TextProvider goodbyeService;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("txt", welcomeTextService.getText());

        return "index";
    }
}
