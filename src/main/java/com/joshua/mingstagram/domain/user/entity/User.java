package com.joshua.mingstagram.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joshua.mingstagram.domain.image.entity.Image;
import com.joshua.mingstagram.global.base.BaseTime;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Setter //FIXME : Setter private 으로 static 메소드 변경해야함
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Entity
public class User extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
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
