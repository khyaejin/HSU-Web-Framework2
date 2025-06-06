package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.dto.UserInfoDto;
import kr.ac.hansung.cse.hellospringdatajpa.entity.UserRole;
import kr.ac.hansung.cse.hellospringdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping("/register")
    public String register(@ModelAttribute UserInfoDto userInfoDto, Model model) {
        userService.add(userInfoDto);
        return "redirect:/login"; // 로그인 페이지로 이동
    }

    // 로그인 (SecurityConfig에서 처리)
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
