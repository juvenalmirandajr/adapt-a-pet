package com.launchacademy.dtos;

import lombok.Data;

@Data
public class AdoptablePetDto {
    private Integer id;
    private String name;
    private String img_url;
    private Integer age;
    private Boolean vaccination_status;
    private String adoption_story;
    private String adoption_status;
    private Integer pet_type_id;
}
