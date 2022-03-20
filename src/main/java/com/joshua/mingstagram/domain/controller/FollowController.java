package com.joshua.mingstagram.domain.controller;

import com.joshua.mingstagram.domain.model.Follow;
import com.joshua.mingstagram.domain.model.User;
import com.joshua.mingstagram.domain.repository.FollowRepository;
import com.joshua.mingstagram.domain.repository.UserRepository;
import com.joshua.mingstagram.global.auth.MyUserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FollowController {

    //FIXME : Facade, Layer 분리

    private final UserRepository userRepository;

    private final FollowRepository followRepository;

    @PostMapping ("/follow/{id}")
    public @ResponseBody String follow (@AuthenticationPrincipal MyUserDetail userDetail,
                                        @PathVariable Long id) {

        User fromUser = userDetail.getUser();

        User toUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found user"));

        Follow follow = new Follow();
        follow.setFromUser(fromUser);
        follow.setToUser(toUser);

        followRepository.save(follow);

        return "ok";
    }

    @DeleteMapping ("/follow/{id}")
    public @ResponseBody String unFollow (@AuthenticationPrincipal MyUserDetail userDetail,
                                          @PathVariable Long id) {

        User fromUser = userDetail.getUser();

        User toUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found user"));

        followRepository.deleteByFromUserIdAndToUserId(fromUser.getId(), toUser.getId());

//        List<Follow> follows = followRepository.findAll();

        return "ok";
    }


}
