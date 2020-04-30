package com.launchacademy.mappers;

import com.launchacademy.dtos.TypeContainerDto;
import com.launchacademy.models.AdoptablePet;
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


}
