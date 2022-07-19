package example.login.service;

import example.login.domain.Member;
import example.login.repository.MemberRepository;
import example.login.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    MemberRepository memberRepository = new MemoryMemberRepository();

    public String join(Member member) {
        // 회원 중복 예외
        memberDuplicationException(member);

        memberRepository.save(member);
        return member.getUserid();
    }

    private void memberDuplicationException(Member member) {
        memberRepository.findById(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다"); // RequestMapping 의 값이 중복되어 나타나는 에러
                });
    }

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId) {
        return memberRepository.findById(memberId);
    }
}
