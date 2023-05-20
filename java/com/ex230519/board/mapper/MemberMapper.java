package com.ex230519.board.mapper;

import com.ex230519.board.dto.MemberDto;
import com.ex230519.board.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member MemberDtoToMember(MemberDto dto){
        Member member = new Member(
                null,
                dto.getName(),
                dto.getId(),
                dto.getPassword(),
                null
        );
        return member;
    }

    public MemberDto MemberToMemberDto(Member member){
        MemberDto dto = new MemberDto();
        dto.setId(member.getId());
        dto.setPassword(member.getPassword());
        dto.setName(member.getName());
        return dto;
    }
}
