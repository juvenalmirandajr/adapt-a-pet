package com.launchacademy.controllers.api.v1;

import com.launchacademy.models.AdoptionApplication;
import com.launchacademy.repositories.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adoptionApplications")
public class AdoptionApplicationRestApiController {
    @Autowired
    private AdoptionApplicationRepository repository;

    @GetMapping
    Iterable<AdoptionApplication> all() {
        return repository.findAll();
    }
}
