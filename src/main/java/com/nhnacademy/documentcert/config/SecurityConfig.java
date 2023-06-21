package com.nhnacademy.documentcert.config;

import com.nhnacademy.documentcert.auth.LoginSuccessHandler;
import com.nhnacademy.documentcert.auth.SimpleLogoutSuccessHandler;
import com.nhnacademy.documentcert.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // 요청 경로 권한 설정
                .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/private-project/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MEMBER")
                .requestMatchers("/certificate-issue/**", "/redirect-index").authenticated()
                .anyRequest().permitAll()
                .and()

                // 로그인 페이지 및 해당 로그인 폼에서 파라미터 id, pwd 지정
                .formLogin()
                .usernameParameter("id")
                .passwordParameter("pwd")
                .loginPage("/auth/login")
                .loginProcessingUrl("/login")
                .and()

                // 요청 경로에 대한 채널 보안 요구사항
                .requiresChannel()
                .requestMatchers("/admin/**", "/private-project/**", "/project/**").requiresSecure()
                .anyRequest().requiresInsecure()
                .and()

                .oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository())
                .authorizedClientService(authorizedClientService())
                .successHandler(loginSuccessHandler())
                .and()

                // 로그아웃 폼 설정
                .logout()
                .deleteCookies("LOGIN")
                .invalidateHttpSession(true)
                .logoutSuccessHandler(logoutSuccessHandler())
                .and()

                // csrf 활성 | 비활성
                .csrf()
//                .disable()
                .and()

                .sessionManagement()
                .sessionFixation()
                .none()
                .and()

                // 헤더 설정
                .headers()
                .defaultsDisabled()
                .frameOptions().sameOrigin()
                .and()

                // 익셉션 에러 핸들링
                .exceptionHandling()
                .accessDeniedPage("/error/403")
                .and()

                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new SimpleLogoutSuccessHandler();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(github());
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService() {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
    }

    @Bean
    public ClientRegistration github() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .userNameAttributeName("login")
                .clientId("6f1c47f2ba8556aefe6f")
                .clientSecret("1cb39eb64a0bb9488c682cd01c6d1a92a8169b6c")
                .authorizationUri("https://github.com/login/oauth/authorize")
                .tokenUri("https://github.com/login/oauth/access_token")
                .userInfoUri("https://api.github.com/user")
                .redirectUriTemplate("http://localhost:8080/login/oauth2/code/github")
                .clientName("GitHub")
                .build();
    }
}
