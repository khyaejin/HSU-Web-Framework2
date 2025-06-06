package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.dto.CreateUserDto;
import kr.ac.hansung.cse.hellospringdatajpa.entity.Product;
import kr.ac.hansung.cse.hellospringdatajpa.service.ProductService;
import kr.ac.hansung.cse.hellospringdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 회원가입
    public String register(CreateUserDto createUserDto, Model model) {
        userService.add(createUserDto);
        return "home";
    }



}
