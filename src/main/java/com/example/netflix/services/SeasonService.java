package com.example.netflix.services;

import com.example.netflix.models.Season;
import com.example.netflix.models.UserModel;
import com.example.netflix.repos.SeasonRepository;
import com.example.netflix.utils.SeasonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonService {
    @Autowired
    SeasonRepository seasonRepository;

    public Season getSeasonById(Long id) { return seasonRepository.findById(id).get(); }


    public Season createSeason(SeasonDTO seasonDTO){
        Season season=Season.from(seasonDTO);
        return seasonRepository.save(season);
    }

    public Season findByNumber(Integer seasonNumber) {
        return seasonRepository.findSeasonBySeasonNumber(seasonNumber).orElseThrow();
    }

}
