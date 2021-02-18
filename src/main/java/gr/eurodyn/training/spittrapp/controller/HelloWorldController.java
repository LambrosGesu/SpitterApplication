package gr.eurodyn.training.spittrapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello(){
//        ModelAndView modelAndView = new ModelAndView("hello");
        return  "hello";
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String NewHello() {
////        ModelAndView modelAndView = new ModelAndView("hello");
//        return "hello";
//    }
}
