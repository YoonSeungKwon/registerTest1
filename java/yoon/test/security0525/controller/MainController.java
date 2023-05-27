package yoon.test.security0525.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yoon.test.security0525.dto.MemberDto;
import yoon.test.security0525.security.auth.MemberDetailService;
import yoon.test.security0525.security.auth.MemberDetails;
import yoon.test.security0525.service.MainService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    private final MemberDetailService memberDetailService;

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String join(MemberDto dto, Model model){
        System.out.println(dto);
        mainService.join(dto);
        model.addAttribute("name", dto.getName());
        return "main";
    }

    @GetMapping("/in")
    public String in(){
        return "in";
    }

}
