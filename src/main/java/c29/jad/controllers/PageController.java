package c29.jad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(value = "page")
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value ="/model")
    public String model(Model model){
        model.addAttribute("message","Hello World");
        return "index";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView testing(){
        var modelAndView = new ModelAndView("index");
        modelAndView.addObject("message","Generated by Thymeleaf");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("loginNow", "Please login first");
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model){
        return "about";
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public String classes(Model model){
        return "classes";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model){
        return "contact";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){
        return "register";
    }

    @RequestMapping(value = "/gym", method = RequestMethod.GET)
    public String gym(Model model){
        return "gym";
    }

    @RequestMapping(value = "/thank-you", method = RequestMethod.GET)
    public String thankyou(Model model){
        return "thank-you";
    }

    @RequestMapping(value = "/checkin", method = RequestMethod.GET)
    public String checkin(Model model){
        return "checkin";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model){
        return "profile";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){
        model.addAttribute("message","Welcome Admin");
        return "admin";
    }


    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String booking(Model model){
        return "booking";
    }
}
