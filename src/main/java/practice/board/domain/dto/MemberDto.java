package practice.board.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.board.domain.entity.Member;

@Data
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String email;

    @Builder
    public MemberDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}
