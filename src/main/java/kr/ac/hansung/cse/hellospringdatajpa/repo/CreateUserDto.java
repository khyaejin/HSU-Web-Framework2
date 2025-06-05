package kr.ac.hansung.cse.hellospringdatajpa.repo;

import lombok.Getter;

@Getter
public class CreateUserDto {
    String email;
    String password;
}
