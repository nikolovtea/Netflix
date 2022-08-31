package com.example.netflix.repos;

import com.example.netflix.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    Optional<Season> findSeasonBySeasonNumber(Integer seasonNumber);
}
