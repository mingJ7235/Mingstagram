package com.joshua.mingstagram.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    @GetMapping ("/auth/login")
    public String login () {
        return "auth/login";
    }

    @GetMapping ("/auth/kakao-login")
    public String kakaoLogin () {
        return "auth/kakaoLogin";
    }
}
