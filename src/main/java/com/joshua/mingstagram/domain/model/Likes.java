package com.joshua.mingstagram.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joshua.mingstagram.global.base.BaseTime;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter //FIXME : private
//@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Likes extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn (name = "userId")
    @JsonIgnoreProperties ({"images", "password", "name", "website", "bio", "email", "gender", "createdDate", "updatedDate"})
    private User user; // id, username, profileImage 만 가져옴

    @ManyToOne
    @JoinColumn (name = "imageId")
    @JsonIgnoreProperties ({"tags", "user", "likesList"})
    private Image image; //
}
