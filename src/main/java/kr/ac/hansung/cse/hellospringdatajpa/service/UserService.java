package kr.ac.hansung.cse.hellospringdatajpa.service;

import kr.ac.hansung.cse.hellospringdatajpa.entity.User;
import kr.ac.hansung.cse.hellospringdatajpa.entity.UserRole;
import kr.ac.hansung.cse.hellospringdatajpa.repo.CreateUserDto;
import kr.ac.hansung.cse.hellospringdatajpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원 추가
    public void add(CreateUserDto dto) {
        User user = User.from(dto);
        userRepository.save(user);
    }

}
