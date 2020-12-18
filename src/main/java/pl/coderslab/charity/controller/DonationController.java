package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryServiceInterface;
import pl.coderslab.charity.service.DonationServiceInterface;
import pl.coderslab.charity.service.InstitutionServiceInterface;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {
    private final CategoryServiceInterface categoryService;
    private final InstitutionServiceInterface institutionService;
    private final DonationServiceInterface donationService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/add")
    public String addDonation(@ModelAttribute Donation donation){
        donationService.save(donation);
        return "form-confirmation";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions() {
        return institutionService.findAll();
    }
}
