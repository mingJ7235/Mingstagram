package com.joshua.mingstagram.domain.follow.repository;

import com.joshua.mingstagram.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    // unFollow logic
    @Transactional //FIXME : service layer 변경 후 뺄 것
    void deleteByFromUserIdAndToUserId(Long fromUserId, Long toUserId);

    int countByFromUserIdAndToUserId(Long fromUserId, Long toUserId);

    List<Follow> findByFromUserId (Long fromUserId);

    List<Follow> findByToUserId (Long toUser);

}
