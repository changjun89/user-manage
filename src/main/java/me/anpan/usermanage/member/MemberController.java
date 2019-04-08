package me.anpan.usermanage.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {
    private static final Logger log  = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberRepository userRepository;

    @GetMapping("/loginform")
    public String loginPage(HttpServletRequest req) {
        return "/member/login.html";
    }

    @GetMapping("/failLogin")
    public String failLoginPage() {
        return "/member/login_failed.html";
    }

    @PostMapping("/login")
    public String login(Member member ,BindingResult result,
                        HttpServletRequest request) {
        if (result.hasErrors()) {
            return "/member/login_failed.html";
        }
        request.getSession().setAttribute("member",member);
        return "/member/list.html";
    }


    @GetMapping("/form")
    public String userForm(Model model) {
        return "/member/form.html";
    }

    @PostMapping("/create")
    public String createUser(@Valid Member member, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/member/login_failed.html";
        }
        MemberRole role = new MemberRole();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        role.setRoleName("BASIC");
        member.setRoles(Arrays.asList(role));
        Member newMember = userRepository.save(member);
        log.info("새롭게 등록된 사용자 : {}",newMember);
        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        List<Member> userList = userRepository.findAll();
        model.addAttribute("members",userList);
        return "/member/list";
    }

    @GetMapping("/modifyForm")
    public String modifyMember(Model model,HttpServletRequest request) {
        List<Member> userList = userRepository.findAll();
        if(userList.size() > 0) {
            model.addAttribute("member",userList.get(0));
        }
        return "/member/modify.html";
    }

    @PostMapping("/modify")
    public String modifyMember(@Valid Member member,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/member/login_failed.html";
        }
        userRepository.save(member);
        return "";
    }






}
