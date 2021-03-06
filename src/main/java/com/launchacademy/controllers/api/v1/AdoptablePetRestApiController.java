package com.launchacademy.controllers.api.v1;

import com.launchacademy.dtos.AdoptablePetDto;
import com.launchacademy.dtos.TypeContainerDto;
import com.launchacademy.models.Admin;
import com.launchacademy.models.AdoptablePet;
import com.launchacademy.models.AdoptionApplication;
import com.launchacademy.repositories.AdminRepository;
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
    private final AdminRepository adminRepo;
    private final ReactService reactService;

    @Autowired
    public AdoptablePetRestApiController(AdoptablePetRepository repository, AdoptionApplicationRepository adoptionRepository, AdminRepository adminRepo, ReactService reactService) {
        this.repository = repository;
        this.adoptionRepository = adoptionRepository;
        this.adminRepo = adminRepo;
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
    public List<AdoptablePetDto> findByPetType(@PathVariable String petType) {
        return reactService.findByPetType(petType);
    }


    @GetMapping("/{id}")
    public AdoptablePetDto one(@PathVariable Integer id) {
        return reactService.findById(id);
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {
        return adminRepo.findByPassword(admin.getPassword());
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
                    adoptablePet.setAdoptionApplications(newAdoptablePet.getAdoptionApplications());
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
            if (adoptableDeletion.getAdoptionApplications() != null) {
                for (AdoptionApplication adoptionApplication : adoptableDeletion.getAdoptionApplications())
                adoptionRepository.delete(adoptionApplication);
            }
            repository.delete(adoptableDeletion);
        }

    }
}
