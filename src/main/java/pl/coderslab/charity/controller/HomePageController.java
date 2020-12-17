package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionServiceInterface;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final InstitutionServiceInterface institutionService;

    @GetMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionMap = institutionService.findAll();
        model.addAttribute("institutions", institutionMap);
        return "index";
    }

//    @ModelAttribute("institutions")
//    public List<Institution> getAllInstitutions(){
//        return institutionService.findAll();
//    }
}
