package com.launchacademy.dtos;

import lombok.Data;

@Data
public class AdoptionApplicationDto {
    private Integer id;
    private String person_name;
    private String phone_number;
    private String email;
    private String home_status;
    private String application_status;
    private String pet_name;
    private String img_url;
    private Boolean vaccination_status;
    private String adoption_story;
    private String adoption_status;
}
