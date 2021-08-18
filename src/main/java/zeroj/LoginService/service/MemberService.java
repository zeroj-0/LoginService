package zeroj.LoginService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zeroj.LoginService.domain.Member;
import zeroj.LoginService.repository.MemberRepository;

import java.util.Optional;

@Transactional
public class MemberService {
    private MemberRepository memberRepository;

    //@Autowired함으로써 서로 연결해줌
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member){

        duplicateMember(member);
        memberRepository.save(member);


        return member.getId();
    }

    private void duplicateMember(Member member) {
        Optional<Member> result1 = memberRepository.findById(member.getId());
        result1.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 아이디입니다");
        });
    }


}
