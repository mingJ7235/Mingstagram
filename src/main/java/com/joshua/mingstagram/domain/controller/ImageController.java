package com.joshua.mingstagram.domain.controller;

import com.joshua.mingstagram.domain.model.User;
import com.joshua.mingstagram.domain.repository.UserRepository;
import com.joshua.mingstagram.global.auth.MyUserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ImageController {

    private final UserRepository userRepository;

    @GetMapping ({"/", "/image/feed"})
    public String imageFeed (@AuthenticationPrincipal MyUserDetail userDetail, Model model) {

        log.info("username : {}", userDetail.getUsername());

        User user = userRepository.findByUsername(userDetail.getUsername());

        model.addAttribute("principalId", user.getId());

        return "image/feed";
    }

}
