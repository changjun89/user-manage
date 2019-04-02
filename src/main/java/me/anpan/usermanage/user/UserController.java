package me.anpan.usermanage.user;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String loginPage() {
        return "/user/login.html";
    }

    @GetMapping("/form")
    public String userForm() {
        return "/user/form.html";
    }

    @PostMapping("/create")
    public String createUser(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/user/login_failed.html";
        }
        return "redirect:/user/list";
    }

    @GetMapping("list")
    public String userList(HashMap model) {
        model.put("userList",model);
        return "/user/list";
    }


}
