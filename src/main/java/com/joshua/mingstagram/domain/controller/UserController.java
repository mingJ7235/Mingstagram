package com.joshua.mingstagram.domain.controller;

import com.joshua.mingstagram.domain.model.User;
import com.joshua.mingstagram.domain.repository.FollowRepository;
import com.joshua.mingstagram.domain.repository.UserRepository;
import com.joshua.mingstagram.global.auth.MyUserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
//@RequestMapping("/auth")
public class UserController {

    private final BCryptPasswordEncoder encoder;

    private final UserRepository userRepository;

    private final FollowRepository followRepository;

    @GetMapping("/auth/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/auth/join")
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

    @GetMapping("/user/{id}")
    public String profile(@AuthenticationPrincipal MyUserDetail userDetail,
                          @PathVariable Long id,
                          Model model) {
        /**
         *   1. imageCount
         *   2. followerCount
         *   3. followingCount
         *   4. User 오브젝트 (Image (likeCount) 컬렉션)
         *   5. followCheck 팔로우 유무 (1 팔로우, 1이 아니면 언팔로우)
         */

        // 4. User 오브젝트
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found user"));

        model.addAttribute("user", user);

        // 5. followCheck 팔로우 유무 (1 팔로우, 1이아니면 언팔로우)
        User principal = userDetail.getUser();

        int followCheck = followRepository.countByFromUserIdAndToUserId(principal.getId(), id);
        log.info("followCheck : {}", followCheck);

        model.addAttribute("followCheck", followCheck);

        return "user/profile";
    }

    @GetMapping ("/user/edit/{id}")
    public String userEdit (@PathVariable Long id) {

        // 해당 id로 select 할것 -> 본인 id 만 접근 가능하도록
        // findByUserInfo ()

        return "user/profile_edit";
    }

}
