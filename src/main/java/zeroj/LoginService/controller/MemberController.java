package zeroj.LoginService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import zeroj.LoginService.domain.Member;

@Controller
public class MemberController {

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


        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String loginService(){
        return "members/loginComplete";
    }

    @GetMapping("/members/retouch")
    public String retouchMember(){
        return "members/retouchMemberForm";
    }
}
