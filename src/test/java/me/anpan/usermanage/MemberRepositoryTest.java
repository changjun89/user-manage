package me.anpan.usermanage;

import lombok.extern.java.Log;
import me.anpan.usermanage.member.Member;
import me.anpan.usermanage.member.MemberRepository;
import me.anpan.usermanage.member.MemberRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void insertTest() {
        for(int i=0; i<100; i++) {
            Member member = new Member();
            member.setUserId("user" + i);
            member.setName("userName"+i);
            member.setPassword("pw" + i);
            member.setEmail("hihi@" + i);
            MemberRole role = new MemberRole();
            if(i <= 80) {
                role.setRoleName("BASIC");
            }else if(i <= 90) {
                role.setRoleName("MANAGER");
            }else {
                role.setRoleName("ADMIN");
            }
            member.setRoles(Arrays.asList(role));
            memberRepository.save(member);
        }
    }

    @Test
    public void testMember() {
        Optional<Member> result = memberRepository.findById(85L);
        //Optional<Member> result = Optional.ofNullable(memberRepository.findById(85)));
        result.ifPresent(member -> log.info("member " + member));
    }
}

