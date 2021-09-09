package zeroj.LoginService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import zeroj.LoginService.domain.Member;
import zeroj.LoginService.repository.JpaRepository;

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

        if (isExist(member,loginForm)) {
            return "members/loginComplete";
        }
        return "redirect:/";
    }

    private boolean isExist(Member member, LoginForm loginForm) {
        boolean isLoginId = loginForm.getId().equals(member.getId());
        boolean isLoginPassword = loginForm.getPassword().equals(member.getPassword());
        return isLoginId && isLoginPassword;
    }
}
