package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.entity.Product;
import kr.ac.hansung.cse.hellospringdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

//    @Autowired
//    private UserService service;
//
//    @GetMapping({"", "/"}) // products 또는 /products/ 둘 다 매핑
//    public String viewHomePage(Model model) {
//
//        List<Product> listProducts = service.listAll();
//        model.addAttribute("listProducts", listProducts);
//
//        return "index";
//    }

}
