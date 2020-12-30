package pl.coderslab.charity.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final InstitutionService institutionService;
    private final DonationService donationServiceInterface;

    @GetMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionMap = institutionService.findAll();
        model.addAttribute("institutions", institutionMap);
        try{
            Long allBagsSum = donationServiceInterface.sumBagsFromAllDonations();
            model.addAttribute("allBags", allBagsSum);
        } catch (NullPointerException e){
            model.addAttribute("allBags", 0);
        }
        try{
            Long allDonations = donationServiceInterface.sumAllDonations();
            model.addAttribute("allDonations", allDonations);
        }catch (NullPointerException exception){
            model.addAttribute("allDonations", 0);
        }
        return "index";
    }
}
