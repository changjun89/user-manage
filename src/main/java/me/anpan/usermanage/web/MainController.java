package me.anpan.usermanage.web;

import me.anpan.usermanage.member.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainController(Principal principal) {
        if(principal !=null) {
            System.out.println("user name : " +principal.getName());
        }
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if(authentication.isAuthenticated()) {
//            System.out.println("login USER : " +authentication.getPrincipal());
//            if(!"anonymousUser".equals(authentication.getPrincipal())){
//                User principal = (User) authentication.getPrincipal();
//                System.out.println("username : "+principal.getUsername());
//                System.out.println("userpwd : "+principal.getPassword());
//
//            }
//        }
        return "/index.html";
    }
}

