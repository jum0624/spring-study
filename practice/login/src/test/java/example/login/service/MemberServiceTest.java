package example.login.service;

import example.login.domain.Member;
import example.login.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member("admin", "1234", "spring");

        //when
        String saveId = memberService.join(member);

        //then
        Member result = memberService.findOne(saveId).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void 회원중복예외() {
        //given
        Member member1 = new Member("admin", "1234", "spring");
        Member member2 = new Member("admin", "4567", "spring");

        //when
        memberService.join(member1);

        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}