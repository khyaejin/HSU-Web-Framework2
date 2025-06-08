package kr.ac.hansung.cse.hellospringdatajpa.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register", "/users/login", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")              // 관리자 권한 필요
                        .requestMatchers("/products/**").hasAnyRole("ADMIN", "USER")// 사용자, 관리자 권한 가능
                        .anyRequest().authenticated()                               // 그 외 모든 요청 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/users/login")                                  // 로그인 페이지
                        .loginProcessingUrl("/login")                               // 로그인 처리 URL
                        .defaultSuccessUrl("/users/login?success", true)           // 로그인 성공 시 이동 (모달 처리를 위해)
                        .failureUrl("/users/login?error=true")                      // 로그인 실패 시 이동
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/users/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }
}
