package com.joshua.mingstagram.domain.image.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.joshua.mingstagram.domain.likes.entity.Likes;
import com.joshua.mingstagram.domain.tag.entity.Tag;
import com.joshua.mingstagram.domain.user.entity.User;
import com.joshua.mingstagram.global.base.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter //FIXME : private
//@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    private String location; // 사진 위치

    private String caption; // 사진 설명

    private String postImage; // 포스팅할 사진의 경로 + 이름

    @Transient //DB 영향 가지 않도록 함
    private Long likeCount;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "userId")
    @JsonIgnoreProperties ({"password", "images"})
    private User user;

    @OneToMany (mappedBy = "image")
    private List<Likes> likesList = new ArrayList<>();

    @OneToMany (mappedBy = "image")
    @JsonManagedReference
    private List<Tag> tags = new ArrayList<>();

}
