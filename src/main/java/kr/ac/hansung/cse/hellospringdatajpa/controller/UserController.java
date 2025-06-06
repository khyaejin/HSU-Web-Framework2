package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.dto.UserInfoDto;
import kr.ac.hansung.cse.hellospringdatajpa.entity.UserRole;
import kr.ac.hansung.cse.hellospringdatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입 폼 렌더링
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserInfoDto()); // ← 여기 반드시 있어야 함
        return "register";
    }

    // ===================================

    // 회원가입 기능 구현
    @PostMapping("/register")
    public String register(@ModelAttribute UserInfoDto userInfoDto, Model model) {
        userService.add(userInfoDto);
        return "redirect:/users/login";
    }

    // 로그인 기능 구현
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
