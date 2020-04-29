package com.launchacademy.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table(name = "pet_types")
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

    @OneToMany(mappedBy = "petType", cascade = CascadeType.ALL)
    private List<AdoptablePet> adoptablePets;


}
