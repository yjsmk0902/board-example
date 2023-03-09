package practice.board.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.board.domain.dto.SignRequest;
import practice.board.domain.dto.SignResponse;
import practice.board.repository.MemberRepository;
import practice.board.web.service.SignService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SignController {

    private final MemberRepository memberRepository;
    private final SignService signService;

    //signup 회원가입

    @GetMapping("/signup")
    public String signup() {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(SignRequest request) throws Exception {
        signService.register(request);
        return "redirect:/";
    }

    //Login 로그인

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(SignRequest request) throws Exception {
        signService.login(request);
        return "redirect:/";
    }

    @GetMapping("/login/page")
    public String loginCheck(@RequestParam String account, Model model) throws Exception {
        model.addAttribute("user", signService.getMember(account));
        return "member/loginPage";
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(signService.getMember(account), HttpStatus.OK);
    }
}
