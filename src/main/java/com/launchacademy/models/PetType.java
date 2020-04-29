package com.launchacademy.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "pet_types")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PetType {
    @Id
    @SequenceGenerator(name = "pet_types_generator", sequenceName = "pet_types_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_types_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column
    @NotBlank
    private String type;

    @Column
    private String description;

    @OneToMany(mappedBy = "petType", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("petType")
    private List<AdoptablePet> adoptablePets = new ArrayList<>();

}
