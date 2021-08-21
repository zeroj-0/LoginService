package zeroj.LoginService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zeroj.LoginService.domain.Member;
import zeroj.LoginService.repository.MemberRepository;

import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired함으로써 서로 연결해줌
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member){

        duplicateMember(member);
        dubbleName(member);

        memberRepository.save(member);


        return member.getId();
    }

    private void dubbleName(Member member) {
        Optional<Member> byName = memberRepository.findByName(member.getName());
        byName.ifPresent(n -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    private void duplicateMember(Member member) {
        Optional<Member> result1 = memberRepository.findById(member.getId());
        result1.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 아이디입니다");
        });
    }


}
