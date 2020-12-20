package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.exception.UserAlreadyExistException;
import pl.coderslab.charity.service.UserService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
        private final UserService userService;

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute(new User());
        return "register";
    }

    @PostMapping("/registration")
    public String registrationAction(@ModelAttribute User user, Model model){
        try {
            userService.saveUser(user);
        } catch (UserAlreadyExistException e) {
            model.addAttribute("userExists", true);
            return "register";
        }
        return "index";
    }
}
