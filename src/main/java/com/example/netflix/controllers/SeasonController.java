package com.example.netflix.controllers;

import com.example.netflix.models.Season;
import com.example.netflix.models.UserModel;
import com.example.netflix.services.SeasonService;
import com.example.netflix.services.UserService;
import com.example.netflix.utils.AuthDTO;
import com.example.netflix.utils.SeasonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("season")
@CrossOrigin("*")
public class SeasonController {
    @Autowired
    public SeasonService seasonService;

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Long id) {return ResponseEntity.ok(seasonService.getSeasonById(id));}

    @PostMapping
    public ResponseEntity<Season> addSeason(@RequestBody SeasonDTO seasonDTO) throws Exception {
        return ResponseEntity.ok(seasonService.createSeason(seasonDTO));
    }

}
