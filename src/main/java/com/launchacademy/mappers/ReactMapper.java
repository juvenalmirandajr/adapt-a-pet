package com.launchacademy.mappers;

import com.launchacademy.dtos.*;
import com.launchacademy.models.AdoptablePet;
import com.launchacademy.models.AdoptionApplication;
import com.launchacademy.models.SurrenderApplication;
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

    default SurrenderApplicationDto surrenderApplicationToSurrenderApplicationDto(SurrenderApplication surrenderApplication){
        SurrenderApplicationDto dto = new SurrenderApplicationDto();
        dto.setId(surrenderApplication.getId());
        dto.setName(surrenderApplication.getName());
        dto.setPhone_number(surrenderApplication.getPhoneNumber());
        dto.setEmail(surrenderApplication.getEmail());
        dto.setPet_name(surrenderApplication.getPetName());
        dto.setPet_age(surrenderApplication.getPetAge());
        dto.setPet_type_id(surrenderApplication.getPetType().getId());
        dto.setPet_img_url(surrenderApplication.getImgUrl());
        dto.setVaccination_status(surrenderApplication.getVaccinationStatus());
        dto.setApplication_status(surrenderApplication.getApplicationStatus());
        return dto;
    }

    List<SurrenderApplicationDto> surrenderApplicationsToSurrenderApplicationDtos(List<SurrenderApplication> all);

    default AdoptablePetDto adoptablePetToAdoptablePetDto(AdoptablePet adoptablePet){
        AdoptablePetDto dto = new AdoptablePetDto();
        dto.setId(adoptablePet.getId());
        dto.setName(adoptablePet.getName());
        dto.setImg_url(adoptablePet.getImgUrl());
        dto.setAge(adoptablePet.getAge());
        dto.setVaccination_status(adoptablePet.getVaccinationStatus());
        dto.setAdoption_story(adoptablePet.getAdoptionStory());
        dto.setAdoption_status(adoptablePet.getAdoptionStatus());
        dto.setPet_type_id(adoptablePet.getPetType().getId());
        return dto;
    }

    List<AdoptablePetDto> adoptablePetsToAdoptablePetDtos(List<AdoptablePet> all);

    default AdoptionApplication adoptionApplicationFormDtoToAdoptionApplication(AdoptionApplicationFormDto dto) {
        AdoptionApplication adoption = new AdoptionApplication();
        adoption.setName(dto.getName());
        adoption.setPhoneNumber(dto.getPhoneNumber());
        adoption.setEmail(dto.getEmail());
        adoption.setHomeStatus(dto.getHomeStatus());
        adoption.setApplicationStatus(dto.getApplicationStatus());
        AdoptablePet pet = new AdoptablePet();
        pet.setId(dto.getPetId());
        adoption.setAdoptablePet(pet);
        return  adoption;
    }

    List<AdoptionApplication> adoptionApplicationFormDtosToAdoptionApplications(List<AdoptionApplicationFormDto> all);

   default SurrenderApplication surrenderApplicationDtoToSurrenderApplication(SurrenderApplicationDto surrenderApplicationDto){
       SurrenderApplication surrender = new SurrenderApplication();
       surrender.setName(surrenderApplicationDto.getName());
       surrender.setPhoneNumber(surrenderApplicationDto.getPhone_number());
       surrender.setEmail(surrenderApplicationDto.getEmail());
       surrender.setPetName(surrenderApplicationDto.getPet_name());
       surrender.setPetAge(surrenderApplicationDto.getPet_age());
       surrender.setImgUrl(surrenderApplicationDto.getPet_img_url());
       surrender.setVaccinationStatus(surrenderApplicationDto.getVaccination_status());
       surrender.setApplicationStatus(surrenderApplicationDto.getApplication_status());
       return surrender;
   }
}

