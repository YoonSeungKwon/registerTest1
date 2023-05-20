package com.ex230519.board.controller;

import com.ex230519.board.dto.MemberDto;
import com.ex230519.board.entity.Member;
import com.ex230519.board.mapper.MemberMapper;
import com.ex230519.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    public MemberService memberService;

    @GetMapping("/member/loginPage")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/member/registerPage")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/member/register")
    public String register(MemberDto memberDto){
        memberService.save(memberDto);
        return "main";
    }

    @PostMapping("/member/login")
    public String login(MemberDto memberDto, Model model){
        System.out.println(memberDto);
        List<Member> list = memberService.find(memberDto);
        if(list.get(0) == null){
        }
        else {
            model.addAttribute("list", list.get(0));
        }
        return "check";
    }
}
