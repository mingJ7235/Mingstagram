package com.joshua.mingstagram.domain.image.repository;

import com.joshua.mingstagram.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
