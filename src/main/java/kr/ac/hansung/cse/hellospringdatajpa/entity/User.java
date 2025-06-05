package kr.ac.hansung.cse.hellospringdatajpa.entity;

import jakarta.persistence.*;
import kr.ac.hansung.cse.hellospringdatajpa.repo.CreateUserDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private UserRole role;

    public static User from(CreateUserDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(UserRole.ROLE_USER)
                .build();
    }

}