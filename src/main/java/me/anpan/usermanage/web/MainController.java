package me.anpan.usermanage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainController(Principal principal, HttpServletRequest request) {
        if (principal != null) {
            System.out.println("user name : " + principal.getName());
            return "redirect:/member/list";
        }
        return "redirect:/member/loginform";
    }
}

