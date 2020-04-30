package com.launchacademy.controllers.api.v1;

import com.launchacademy.dtos.AdoptionApplicationDto;
import com.launchacademy.repositories.AdoptionApplicationRepository;
import com.launchacademy.services.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adoptionApplications")
public class AdoptionApplicationRestApiController {
    private final ReactService reactService;
    private final AdoptionApplicationRepository repository;

    @Autowired
    public AdoptionApplicationRestApiController(ReactService reactService, AdoptionApplicationRepository repository) {
        this.reactService = reactService;
        this.repository = repository;
    }

    @GetMapping
    List<AdoptionApplicationDto> all() {
        return reactService.findAllAdoption();
    }
}
