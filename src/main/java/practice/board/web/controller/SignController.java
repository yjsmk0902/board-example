package practice.board.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import practice.board.domain.dto.SignRequestDto;
import practice.board.domain.dto.SignResponseDto;
import practice.board.repository.MemberRepository;
import practice.board.web.service.SignService;

@Controller
@RequiredArgsConstructor
public class SignController {

    private final MemberRepository memberRepository;
    private final SignService signService;

    @PostMapping("/login")
    public ResponseEntity<SignResponseDto> login(@RequestBody SignRequestDto request) throws Exception {
        return new ResponseEntity<>(signService.login(request), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> signup(@RequestBody SignRequestDto request) throws Exception {
        return new ResponseEntity<>(signService.register(request), HttpStatus.OK);
    }

    @GetMapping("/user/get")
    public ResponseEntity<SignResponseDto> getUser(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(signService.getMember(account), HttpStatus.OK);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponseDto> getUserForAdmin(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(signService.getMember(account), HttpStatus.OK);
    }
}
