package com.launchacademy.controllers.api.v1;

import com.launchacademy.models.AdoptablePet;
import com.launchacademy.repositories.AdoptablePetRepository;
import com.launchacademy.repositories.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class AdoptablePetRestApiController {
    @Autowired
    private AdoptablePetRepository repository;
    @Autowired
    private AdoptionApplicationRepository adoptionRepository;

    @GetMapping("adoptablespets")
    Iterable<AdoptablePet> all() {
        return repository.findAll();
    }

    @GetMapping("adoptablespets/{id}")
    public AdoptablePet one(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PostMapping("adoptablespets")
    public AdoptablePet newAdoptablePet(@RequestBody AdoptablePet newAdoptablePet) {
        return repository.save(newAdoptablePet);
    }

    @PutMapping("adoptablespets/{id}")
    public AdoptablePet replaceAdoptablePet(@RequestBody AdoptablePet newAdoptablePet, @PathVariable Integer id) {

        return repository.findById(id)
                .map(adoptablePet -> {
                    adoptablePet.setName(newAdoptablePet.getName());
                    adoptablePet.setImgUrl(newAdoptablePet.getImgUrl());
                    adoptablePet.setAge(newAdoptablePet.getAge());
                    adoptablePet.setVaccinationStatus(newAdoptablePet.getVaccinationStatus());
                    adoptablePet.setAdoptionStory(newAdoptablePet.getAdoptionStory());
                    adoptablePet.setAdoptionStatus(newAdoptablePet.getAdoptionStatus());
                    adoptablePet.setPetType(newAdoptablePet.getPetType());
                    adoptablePet.setAdoptionApplication(newAdoptablePet.getAdoptionApplication());
                    return repository.save(adoptablePet);
                })
                .orElseGet(() -> {
                    newAdoptablePet.setId(id);
                    return repository.save(newAdoptablePet);
                });
    }

    @DeleteMapping("adoptablespets/{id}")
    public void deleteAdoptablePet(@PathVariable Integer id) {
        if (repository.findById(id).isPresent()) {
            AdoptablePet adoptableDeletion = repository.findById(id).get();
            if (adoptableDeletion.getAdoptionApplication() != null) {
                adoptionRepository.delete(adoptableDeletion.getAdoptionApplication());
            }
            repository.delete(adoptableDeletion);
        }

    }
}
