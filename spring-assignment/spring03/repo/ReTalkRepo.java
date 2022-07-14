package com.talk.talk.repo;

import com.talk.talk.domain.ReTalk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReTalkRepo extends JpaRepository<ReTalk, Long> {
    List<ReTalk> findAllByTalkIdOrderByCreatedAtAsc(Long id);
    void deleteByTalkId(Long id);
}
