package com.talk.talk.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TalkRepo extends JpaRepository<Talk, Long> {
    List<Talk> findAllByOrderByCreatedAtDesc();

    @Query("select distinct date from Talk")
    List<LocalDate> getDistinctTalksByDate();
    List<Talk> findAllByDateOrderByCreatedAtAsc(LocalDate date);
}
