package practice.board.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import practice.board.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findByUsername(String username);  //멤버 객체 조회
}
