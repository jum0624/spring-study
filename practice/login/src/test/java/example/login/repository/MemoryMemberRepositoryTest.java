package example.login.repository;

import example.login.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeEach
    void beforeEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("admin", "1234", "spring");

        //when
        memberRepository.save(member);

        //then
        Member result = memberRepository.findById(member.getUserid()).get();  // optional Member 타입에서 get()으로 member꺼내오기
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findById() {

    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("admin", "1234", "spring");
        memberRepository.save(member1);

        Member member2 = new Member("hello", "1234", "spring");
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}