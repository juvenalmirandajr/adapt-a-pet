package com.launchacademy.services;

import com.launchacademy.dtos.AdoptionApplicationDto;
import com.launchacademy.dtos.TypeContainerDto;
import com.launchacademy.mappers.ReactMapper;
import com.launchacademy.models.AdoptablePet;
import com.launchacademy.models.AdoptionApplication;
import com.launchacademy.models.PetType;
import com.launchacademy.repositories.AdoptablePetRepository;
import com.launchacademy.repositories.AdoptionApplicationRepository;
import com.launchacademy.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReactService {
    private final ReactMapper mapper;
    private final PetTypeRepository petTypeRepository;
    private final AdoptablePetRepository adoptablePetRepository;
    private final AdoptionApplicationRepository adoptionApplicationRepository;

    @Autowired
    public ReactService(ReactMapper mapper, PetTypeRepository petTypeRepository, AdoptablePetRepository adoptablePetRepository, AdoptionApplicationRepository adoptionApplicationRepository) {
        this.mapper = mapper;
        this.petTypeRepository = petTypeRepository;
        this.adoptablePetRepository = adoptablePetRepository;
        this.adoptionApplicationRepository = adoptionApplicationRepository;
    }

    public List<TypeContainerDto> findPetType() {
        List<TypeContainerDto> list = new ArrayList<>();
        List<PetType> petTypes = (List<PetType>) petTypeRepository.findAll();
        petTypes.forEach(petType -> {
            List<AdoptablePet> pets = adoptablePetRepository.findByPetType(petType);
            if (pets.size() > 0) {
                list.add(mapper.adoptablePetToTypeContainerDto(pets.get(0)));
            }
        });
        return list;
    }

    public List<AdoptionApplicationDto> findAll() {
        List<AdoptionApplicationDto> list = new ArrayList<>();
        List<AdoptionApplication> all = (List<AdoptionApplication>) adoptionApplicationRepository.findAll();
        return mapper.adoptionApplicationsToAdoptionApplicationDtos(all);
    }
}
