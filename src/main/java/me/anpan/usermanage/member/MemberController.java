package me.anpan.usermanage.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class MemberController {
    private static final Logger log  = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "/member/login.html";
    }

    @GetMapping("/form")
    public String userForm() {
        return "/member/form.html";
    }

    @PostMapping("/create")
    public String createUser(@Valid Member member, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/member/login_failed.html";
        }
        Member newMember = userRepository.save(member);
        log.info("새롭게 등록된 사용자 : {}",newMember);
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String userList(HashMap model) {
        List<Member> userList = userRepository.findAll();
        userList.stream().forEach(o-> System.out.println(o));
        model.put("users",userList);
        return "/member/list.html";
    }




}
