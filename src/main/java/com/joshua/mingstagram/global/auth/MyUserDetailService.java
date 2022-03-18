package com.joshua.mingstagram.global.auth;

import com.joshua.mingstagram.domain.model.User;
import com.joshua.mingstagram.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        MyUserDetail userDetail = null;

        if (user != null) {
            userDetail  = new MyUserDetail();
            userDetail.setUser(user);
        }else {
            throw new UsernameNotFoundException("Not found 'username'");
        }

        return userDetail;
    }

}
