package com.ex230519.board.service;

import com.ex230519.board.dto.MemberDto;
import com.ex230519.board.entity.Member;
import com.ex230519.board.mapper.MemberMapper;
import com.ex230519.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    public MemberRepository memberRepository;
    @Autowired
    public MemberMapper memberMapper;
    public void save(MemberDto memberDto){
        Member member = memberMapper.MemberDtoToMember(memberDto);
        memberRepository.save(member);
    }

    public List<Member> find(MemberDto memberDto){
        Member memberFind = memberRepository.findById(memberDto.getId());
        List<Member> list = new ArrayList<>();
        if(memberFind==null){
            list.add(null);
        }
        else{
            if(!memberFind.getPassword().equals(memberDto.getPassword())){
                list.add(null);
            }
            else{
                list.add(memberFind);
            }
        }
        return list;
    }

}
