package kr.ac.hansung.cse.hellospringdatajpa.domain.admin.service;

import kr.ac.hansung.cse.hellospringdatajpa.domain.user.entity.User;
import kr.ac.hansung.cse.hellospringdatajpa.domain.user.entity.UserRole;
import kr.ac.hansung.cse.hellospringdatajpa.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;

    // 관리자 권한으로 승격
    public void promoteToAdmin(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        user.setRole(UserRole.ROLE_ADMIN);
        userRepository.save(user);
    }
}
