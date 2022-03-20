package com.joshua.mingstagram.domain.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Tag extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "imageId")
    @JsonBackReference
    private Image image;
}
