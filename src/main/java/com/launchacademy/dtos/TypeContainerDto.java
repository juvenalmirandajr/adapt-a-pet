package com.launchacademy.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TypeContainerDto {
    private String type;
    private String description;
    private String img_url;
}
