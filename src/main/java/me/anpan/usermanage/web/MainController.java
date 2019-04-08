package me.anpan.usermanage.web;

import me.anpan.usermanage.member.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainController(Principal principal, HttpServletRequest request) {
        if(principal !=null) {
            System.out.println("user name : " +principal.getName());
            return "redirect:/member/list";
        }
        return "redirect:/member/loginform";
    }
}

