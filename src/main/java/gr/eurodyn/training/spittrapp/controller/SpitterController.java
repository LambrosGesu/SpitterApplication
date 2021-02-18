package gr.eurodyn.training.spittrapp.controller;

import gr.eurodyn.training.spittrapp.domain.Spitter;
import gr.eurodyn.training.spittrapp.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class SpitterController{

    @Autowired
    private SpitterService spitterService;

    @GetMapping("/listSpitters")
    private String listSpitters(Model model){
        List<Spitter> spitters = spitterService.getSpitters();
        model.addAttribute("spitters",spitters);
        return "list-spitters";
    }

}
