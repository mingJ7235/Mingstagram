package com.joshua.mingstagram.domain.model;


import com.joshua.mingstagram.global.base.BaseTime;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter //FIXME : private
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Likes extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;
}
