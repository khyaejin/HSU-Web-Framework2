package kr.ac.hansung.cse.hellospringdatajpa.domain.user.service;

import kr.ac.hansung.cse.hellospringdatajpa.domain.user.entity.User;
import kr.ac.hansung.cse.hellospringdatajpa.domain.user.dto.UserInfoDto;
import kr.ac.hansung.cse.hellospringdatajpa.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 회원 가입
    public void addUser(UserInfoDto dto) {
        User user = User.from(dto, passwordEncoder);
        userRepository.save(user);
    }

    // 로그인 시 사용자 조회
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 찾을 수 없습니다: " + email));
    }

    // 전체 회원 조회
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
