package example.login.repository;

import example.login.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    @Override
    public Member save(Member member) {
        member.getName();
        member.getUserid();
        member.getPasswd();
        store.put(member.getUserid(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String userId) {
        return Optional.ofNullable(store.get(userId));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
