package zeroj.LoginService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginHomeController {

    //localhost:8080으로 들어갔을 때 로그인 화면
    @GetMapping("/")
    public String home(){
        return "loginhome";
    }
}
