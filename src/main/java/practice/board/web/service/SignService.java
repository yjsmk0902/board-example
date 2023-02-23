package practice.board.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.board.domain.dto.SignRequestDto;
import practice.board.domain.dto.SignResponseDto;
import practice.board.domain.entity.Authority;
import practice.board.domain.entity.Member;
import practice.board.repository.MemberRepository;
import practice.board.security.jwt.JwtProvider;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SignService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignResponseDto login(SignRequestDto request) throws Exception{
        Member member = memberRepository.findByAccount(request.getAccount()).orElseThrow(()
                -> new BadCredentialsException("잘못된 계정입니다."));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new BadCredentialsException("잘못된 비밀번호입니다.");
        }

        return SignResponseDto.builder()
                .id(member.getId())
                .account(member.getAccount())
                .name(member.getName())
                .username(member.getUsername())
                .email(member.getEmail())
                .roles(member.getRoles())
                .token(jwtProvider.createToken(member.getAccount(), member.getRoles()))
                .build();
    }

    public boolean register(SignRequestDto request) throws Exception {
        try {
            Member member = Member.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .build();

            member.setRoles(Collections.singletonList(Authority.builder().role("ROLE_USER").build()));

            memberRepository.save(member);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public SignResponseDto getMember(String account) throws Exception {
        Member member = memberRepository.findByAccount(account)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new SignResponseDto(member);
    }
}
