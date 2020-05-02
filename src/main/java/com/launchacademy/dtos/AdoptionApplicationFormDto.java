package com.launchacademy.dtos;

import lombok.Data;

@Data
public class AdoptionApplicationFormDto {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private String homeStatus;
    private String applicationStatus;
    private Integer petId;
}
