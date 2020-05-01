package com.launchacademy.controllers.api.v1;

import com.launchacademy.dtos.SurrenderApplicationDto;
import com.launchacademy.services.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/surrenderApplications")
public class SurrenderApplicationRestApiController {

    private final ReactService reactService;

    @Autowired
    public SurrenderApplicationRestApiController(ReactService reactService) {
        this.reactService = reactService;
    }

    @GetMapping
    List<SurrenderApplicationDto> all() {
        return reactService.findAllSurrender();
    }

    @PostMapping
    SurrenderApplicationDto createSurrenderApplication(@RequestBody SurrenderApplicationDto surrenderApplicationDto) {
        return reactService.newSurrenderApplication(surrenderApplicationDto);
    }
}
