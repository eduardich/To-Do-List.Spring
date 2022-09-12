package main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class DefaultController {

    @Value("${printInDefaultController}")
    private String fromProperties;

    @RequestMapping("/")
    public String index(Model model) {

    return "redirect:/todolist";
    }
}
