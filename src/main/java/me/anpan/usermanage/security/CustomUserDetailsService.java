package me.anpan.usermanage.security;

import me.anpan.usermanage.member.Member;
import me.anpan.usermanage.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserId(username);
        if(member == null) {
            throw new UsernameNotFoundException(username + "사용자 정보가 올바르지 않습니다.");
        }
        return new SecurityMember(memberRepository.findByUserId(username));
    }
}