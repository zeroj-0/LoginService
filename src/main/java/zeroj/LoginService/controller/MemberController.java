package zeroj.LoginService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import zeroj.LoginService.domain.Member;
import zeroj.LoginService.service.MemberService;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setName(form.getName());
        member.setPassword(form.getPassword());

        memberService.join(member);

        return "redirect:/";
    }

//    @GetMapping("/members/login")
//    public String loginService(){
//        return "members/loginComplete";
//    }

    @PostMapping("/members/login")
    public String login(LoginForm loginForm){
        Member member = new Member();
        boolean loginId = loginForm.getId().equals(member.getId());
        boolean loginPassword = loginForm.getPassword().equals(member.getPassword());


        return "members/loginComplete";
    }

    @GetMapping("/members/retouch")
    public String retouchMember(){
        return "members/retouchMemberForm";
    }
}
