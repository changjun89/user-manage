package me.anpan.usermanage.member;

import me.anpan.usermanage.security.SecurityMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    MemberRepository repository;

    public CustomLoginSuccessHandler(String s) {
        setDefaultTargetUrl(s);

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String name = httpServletRequest.getParameter("neme");
        SecurityMember principal = (SecurityMember)authentication.getPrincipal();
        Member member = repository.findByUserId(principal.getUsername());
        httpServletRequest.getSession().setAttribute("member",member);

    }
}
