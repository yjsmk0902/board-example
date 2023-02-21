package practice.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.board.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByAccount(String account);
}
