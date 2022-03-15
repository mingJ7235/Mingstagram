package com.joshua.mingstagram.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joshua.mingstagram.global.base.BaseTime;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter // FIXME : private 으로 추후에 변경
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String name;

    private String website;

    private String bio;

    private String email;

    private String phone;

    private String gender;

    private String profileImage; // profile photo path + photo name

    @OneToMany (mappedBy = "user")
    @JsonIgnoreProperties ({"user", "tags", "likes"})
    private List<Image> images = new ArrayList<>();
}
