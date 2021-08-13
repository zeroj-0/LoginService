package zeroj.LoginService.repository;

import zeroj.LoginService.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(String Id);
    Optional<Member> findByName(String name);
}
