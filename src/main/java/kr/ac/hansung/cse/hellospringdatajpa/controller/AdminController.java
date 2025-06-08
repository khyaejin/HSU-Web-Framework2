package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    // 관리자 페이지로 이동
    @GetMapping("/users")
    public String adminPage(Model model) {
        model.addAttribute("userList", userService.findAllUsers());
        return "admin";
    }

    // 관리자 권한으로 승격
    @PostMapping("/users/promote/{id}")
    public String promoteUserToAdmin(@PathVariable Long id) {
        userService.promoteToAdmin(id);
        return "redirect:/admin/users";
    }

}
