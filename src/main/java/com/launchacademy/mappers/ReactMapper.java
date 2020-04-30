package com.launchacademy.mappers;

import com.launchacademy.dtos.AdoptionApplicationDto;
import com.launchacademy.dtos.TypeContainerDto;
import com.launchacademy.models.AdoptablePet;
import com.launchacademy.models.AdoptionApplication;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface ReactMapper {

    default TypeContainerDto adoptablePetToTypeContainerDto(AdoptablePet adoptablePet) {
        TypeContainerDto dto = new TypeContainerDto();
        dto.setType(adoptablePet.getPetType().getType());
        dto.setDescription(adoptablePet.getPetType().getDescription());
        dto.setImg_url(adoptablePet.getImgUrl());
        return dto;
    }

    List<TypeContainerDto> adoptablePetsToTypeContainerDtos(List<AdoptablePet> list);

    default AdoptionApplicationDto adoptionApplicationToAdoptionApplicationDto(AdoptionApplication adoptionApplication) {
        AdoptionApplicationDto dto = new AdoptionApplicationDto();
        dto.setPerson_name(adoptionApplication.getName());
        dto.setPhone_number(adoptionApplication.getPhoneNumber());
        dto.setEmail(adoptionApplication.getEmail());
        dto.setHome_status(adoptionApplication.getHomeStatus());
        dto.setApplication_status(adoptionApplication.getApplicationStatus());
        dto.setPet_name(adoptionApplication.getAdoptablePet().getName());
        dto.setId(adoptionApplication.getId());
        dto.setImg_url(adoptionApplication.getAdoptablePet().getImgUrl());
        dto.setVaccination_status(adoptionApplication.getAdoptablePet().getVaccinationStatus());
        dto.setAdoption_story(adoptionApplication.getAdoptablePet().getAdoptionStory());
        dto.setAdoption_status(adoptionApplication.getAdoptablePet().getAdoptionStatus());
        return dto;
    }

    List<AdoptionApplicationDto> adoptionApplicationsToAdoptionApplicationDtos(List<AdoptionApplication> all);
}
