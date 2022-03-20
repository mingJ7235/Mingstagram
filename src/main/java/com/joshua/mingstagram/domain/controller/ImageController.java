package com.joshua.mingstagram.domain.controller;

import com.joshua.mingstagram.global.auth.MyUserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ImageController {

    @GetMapping ({"/", "/image/feed"})
    public String imageFeed (@AuthenticationPrincipal MyUserDetail userDetail, Model model) {

        log.info("username : {}", userDetail.getUsername());

        return "image/feed";
    }

}
