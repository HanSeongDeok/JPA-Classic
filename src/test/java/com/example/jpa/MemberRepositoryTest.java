package com.example.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepositoryEx memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        //given
        MemberEx member = new MemberEx();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        MemberEx findMember = memberRepository.find(saveId);

        //print
        System.out.println(findMember.getId() + " : " + member.getId());
        System.out.println(findMember.getUsername() + " : " + member.getUsername());

        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);

    }

}