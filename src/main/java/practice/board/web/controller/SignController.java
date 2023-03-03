package practice.board.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import practice.board.domain.dto.SignRequest;
import practice.board.domain.dto.SignResponse;
import practice.board.repository.MemberRepository;
import practice.board.web.service.SignService;

@Controller
@RequiredArgsConstructor
public class SignController {

    private final MemberRepository memberRepository;
    private final SignService signService;

    @GetMapping("/login")
    public String login() {
        return "null";
    }

    @PostMapping("/login")
    public ResponseEntity<SignResponse> login(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(signService.login(request), HttpStatus.OK);
    }

    @GetMapping("/register")
    public String signup() {
        return "null";
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> signup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(signService.register(request), HttpStatus.OK);
    }

    @GetMapping("/user/get")
    public ResponseEntity<SignResponse> getUser(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(signService.getMember(account), HttpStatus.OK);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(signService.getMember(account), HttpStatus.OK);
    }
}
