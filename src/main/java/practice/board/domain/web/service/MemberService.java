package practice.board.domain.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.board.domain.entity.Member;
import practice.board.domain.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long joinUser(Member member) {
        return memberRepository.save(member).getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();  //읽기 전용
    }

    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);   //읽기 전용
    }
}
