package com.launchacademy.controllers.api.v1;

import com.launchacademy.dtos.ListPageContainerDto;
import com.launchacademy.dtos.TypeContainerDto;
import com.launchacademy.models.AdoptablePet;
import com.launchacademy.repositories.AdoptablePetRepository;
import com.launchacademy.repositories.AdoptionApplicationRepository;
import com.launchacademy.services.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
public class AdoptablePetRestApiController {
    private final AdoptablePetRepository repository;
    private final AdoptionApplicationRepository adoptionRepository;
    private final ReactService reactService;

    @Autowired
    public AdoptablePetRestApiController(AdoptablePetRepository repository, AdoptionApplicationRepository adoptionRepository, ReactService reactService) {
        this.repository = repository;
        this.adoptionRepository = adoptionRepository;
        this.reactService = reactService;
    }

    @GetMapping
    Iterable<AdoptablePet> all() {
        return repository.findAll();
    }

    @GetMapping("/pet_type")
    List<TypeContainerDto> getPetTypeForReactTypeContainer() {
        return reactService.findPetType();
    }

    @GetMapping("type/{petType}")
    public List<ListPageContainerDto> findByPetType(@PathVariable String petType) {
        return reactService.findByPetType(petType);
    }


    @GetMapping("/{id}")
    public AdoptablePet one(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public AdoptablePet newAdoptablePet(@RequestBody AdoptablePet newAdoptablePet) {
        return repository.save(newAdoptablePet);
    }

    @PutMapping("/{id}")
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
