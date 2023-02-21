package practice.board.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practice.board.domain.entity.Member;
import practice.board.repository.MemberRepository;
import practice.board.security.CustomUserDetails;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByAccount(username)
                .orElseThrow(
                () -> new UsernameNotFoundException("Invalid authentication...")
                );

        return new CustomUserDetails(member);
    }
}
