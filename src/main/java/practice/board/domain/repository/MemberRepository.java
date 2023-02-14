package practice.board.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import practice.board.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findByUsername(String username);  //멤버 객체 조회
}
