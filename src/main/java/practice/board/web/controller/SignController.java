package practice.board.web.controller;

import lombok.RequiredArgsConstructor;
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
public class SignController {

    private final MemberRepository memberRepository;
    private final SignService signService;

    @GetMapping("/login")
    public String login(Model model) {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<SignResponse> login(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(signService.login(request), HttpStatus.OK);
    }

    @GetMapping("/register")
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignRequest());
        return "member/signup";
    }

    @PostMapping("/register")
    public String signup(SignRequest request) throws Exception {
        signService.register(request);
        return "redirect:/register/result";
    }

    @GetMapping("/register/result")
    public String signupResult(Model model) throws Exception {
        SignResponse member = signService.getMember("abc123");
        model.addAttribute("member", member);
        return "member/signupResult";
    }

//    Register Test
//    @PostMapping("/register")
//    public ResponseEntity<Boolean> signup(@RequestBody SignRequest request) throws Exception {
//        return new ResponseEntity<>(signService.register(request), HttpStatus.OK);
//    }

    @GetMapping("/user/get")
    public ResponseEntity<SignResponse> getUser(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(signService.getMember(account), HttpStatus.OK);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(signService.getMember(account), HttpStatus.OK);
    }
}
