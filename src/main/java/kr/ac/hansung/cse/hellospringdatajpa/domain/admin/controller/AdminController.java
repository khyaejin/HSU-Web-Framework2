package kr.ac.hansung.cse.hellospringdatajpa.domain.admin.controller;

import kr.ac.hansung.cse.hellospringdatajpa.domain.admin.service.AdminService;
import kr.ac.hansung.cse.hellospringdatajpa.domain.user.service.UserService;
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
    private final AdminService adminService;

    // 관리자 페이지 렌더링
    @GetMapping("/users")
    public String adminPage(Model model) {
        model.addAttribute("userList", userService.findAllUsers());
        return "admin";
    }

    // 관리자 권한으로 승격
    @PostMapping("/users/promote/{id}")
    public String promoteUserToAdmin(@PathVariable Long id) {
        adminService.promoteToAdmin(id);
        return "redirect:/admin/users";
    }

}
