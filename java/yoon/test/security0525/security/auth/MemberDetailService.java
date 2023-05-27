package yoon.test.security0525.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yoon.test.security0525.domain.Member;
import yoon.test.security0525.repository.MainRepository;

@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

    private final MainRepository mainRepository;

    @Override
    public MemberDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = mainRepository.findById(username);

        System.out.println(username);
        System.out.println(member);

        if(member == null){
            throw new UsernameNotFoundException(username);
        }

        MemberDetails memberDetails = new MemberDetails(member);

        return memberDetails;
    }
}
