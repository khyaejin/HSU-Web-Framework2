package kr.ac.hansung.cse.hellospringdatajpa.domain.user.controller;

import kr.ac.hansung.cse.hellospringdatajpa.domain.user.dto.UserInfoDto;
import kr.ac.hansung.cse.hellospringdatajpa.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입 페이지 렌더링
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserInfoDto());
        return "register";
    }

    // 로그인 페이지 렌더링
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "이메일 또는 비밀번호가 올바르지 않습니다.");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "로그아웃 되었습니다.");
        }
        return "login";
    }

    // 회원가입
    @PostMapping("/register")
    public String register(@ModelAttribute UserInfoDto userInfoDto, Model model) {
        userService.addUser(userInfoDto);
        return "redirect:/users/login";
    }
}
