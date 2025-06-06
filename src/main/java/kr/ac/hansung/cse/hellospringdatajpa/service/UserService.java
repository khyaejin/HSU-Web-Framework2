package kr.ac.hansung.cse.hellospringdatajpa.service;

import kr.ac.hansung.cse.hellospringdatajpa.entity.User;
import kr.ac.hansung.cse.hellospringdatajpa.dto.CreateUserDto;
import kr.ac.hansung.cse.hellospringdatajpa.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 회원 추가
    public void add(CreateUserDto dto) {
        User user = User.from(dto, passwordEncoder);
        userRepository.save(user);
    }

}
