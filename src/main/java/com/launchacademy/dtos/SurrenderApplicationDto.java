package com.launchacademy.dtos;

import lombok.Data;

@Data
public class SurrenderApplicationDto {
    private Integer id;
    private String name;
    private String phone_number;
    private String email;
    private String pet_name;
    private Integer pet_age;
    private Integer pet_type_id;
    private String pet_img_url;
    private Boolean vaccination_status;
    private String application_status;
}
