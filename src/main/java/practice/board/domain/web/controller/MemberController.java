package practice.board.domain.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.board.domain.entity.Member;
import practice.board.domain.web.service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/signup")
    public String addForm() {
        log.info("enter signup");
        return "member/signup";
    }

    @PostMapping("/signup")
    public String createMember(@ModelAttribute("member") Member member) {
        log.info("enter createMember");
//        memberService.join(member);
        return "member/signupResult";
    }
}
