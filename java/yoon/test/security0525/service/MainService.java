package yoon.test.security0525.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import yoon.test.security0525.domain.Member;
import yoon.test.security0525.dto.MemberDto;
import yoon.test.security0525.repository.MainRepository;

@Service
@RequiredArgsConstructor
public class MainService {

    private final BCryptPasswordEncoder passwordEncoder;

    private final MainRepository mainRepository;

    public void join(MemberDto dto){
        System.out.println(dto);
        Member member = Member.builder()
                        .id(dto.getId())
                        .password(passwordEncoder.encode(dto.getPassword()))
                        .name(dto.getName())
                        .role("USER")
                        .build();
        System.out.println(member);

        mainRepository.save(member);

    }

}
