package c29.jad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin(Model model){
        model.addAttribute("message","Welcome Admin");
        return "admin";}
}
