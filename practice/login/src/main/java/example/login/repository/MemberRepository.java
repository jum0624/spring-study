package example.login.repository;

import example.login.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(String userId);

    List<Member> findAll();
}
