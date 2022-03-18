package com.joshua.mingstagram.domain.controller;

import com.joshua.mingstagram.domain.model.User;
import com.joshua.mingstagram.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final BCryptPasswordEncoder encoder;

    private final UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/join")
    public String authJoin() {
        return "auth/join";
    }

    @PostMapping("/auth/joinProc")
    public String authJoinProc(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword); //FIXME : setter -> private method
        userRepository.save(user); // FIXME : layer 분리

        return "redirect:/auth/login";
    }

}
