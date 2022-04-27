package com.project.socialMedia.controller;

import com.project.socialMedia.model.userAccount;
import com.project.socialMedia.model.userSignup;
import com.project.socialMedia.repository.userAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

@Controller
public class userAuth {

    @Autowired
    private userAccountRepo userepo;

    @GetMapping("/user/signup")
    public String signupForm(@ModelAttribute userSignup userSignup, Model model) {
        model.addAttribute("userSignup",new userSignup());
        return "users/signup";

    }

    @PostMapping("/user/signup")
    public String signup(@Valid @ModelAttribute("userSignup") userSignup userSignup, BindingResult result, HttpServletRequest request, Model model){









        String uniqueID = UUID.randomUUID().toString();

        userAccount account = new userAccount();
        account.setUserID(uniqueID);
        account.setFirstname(userSignup.getFirstname());
        account.setLastname(userSignup.getLastname());
        account.setUsername(userSignup.getUsername());
        account.setEmail(userSignup.getEmail());
        account.setPassword(userSignup.getPassword());
        account.setYearsOfExperience(userSignup.getYearsOfExperience());
        userAccount save = userepo.save(account);




        return "redirect:/";
    }

}
