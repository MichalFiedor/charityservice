package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationServiceInterface;
import pl.coderslab.charity.service.InstitutionServiceInterface;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final InstitutionServiceInterface institutionService;
    private final DonationServiceInterface donationServiceInterface;

    @GetMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionMap = institutionService.findAll();
        model.addAttribute("institutions", institutionMap);
        long allBagsSum = donationServiceInterface.sumBagsFromAllDonations();
        model.addAttribute("allBags", allBagsSum);
        long allDonations = donationServiceInterface.sumAllDonations();
        model.addAttribute("allDonations", allDonations);
        return "index";
    }



}
