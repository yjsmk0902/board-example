package practice.board.domain.dto;

import lombok.Data;

@Data
public class SignRequest {
    private Long id;
    private String account;
    private String password;
    private String username;
    private String name;
    private String email;
}
