package zeroj.LoginService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import zeroj.LoginService.domain.Member;

@Controller
public class LoginHomeController {

    //localhost:8080으로 들어갔을 때 로그인 화면
    @GetMapping("/")
    public String home(){
        return "loginhome";
    }

    @PostMapping("/")
    public String login(LoginForm loginForm){
        Member member = new Member();
        boolean loginId = loginForm.getId().equals(member.getId());
        boolean loginPassword = loginForm.getPassword().equals(member.getPassword());

        if (loginId == true && loginPassword == true)
            return "members/loginComplete";
        else return "redirect:/";
    }
}
