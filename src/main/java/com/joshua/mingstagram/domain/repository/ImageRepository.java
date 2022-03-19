package com.joshua.mingstagram.domain.repository;

import com.joshua.mingstagram.domain.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
