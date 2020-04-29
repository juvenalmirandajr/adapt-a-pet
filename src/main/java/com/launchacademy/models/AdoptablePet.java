package com.launchacademy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "adoptable_pets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdoptablePet {
    @Id
    @SequenceGenerator(name = "adoptable_pets_generator", sequenceName = "adoptable_pets_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoptable_pets_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @NotBlank
    @Column
    private String name;

    @URL
    @NotBlank
    @Column(name = "img_url")
    private String imgUrl;

    @Column
    private Integer age;

    @Column(name = "vaccination_status")
    private Boolean vaccinationStatus;

    @NotBlank
    @Column(name = "adoption_story")
    private String adoptionStory;

    @NotBlank
    @Column(name = "adoption_status")
    private String adoptionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_type_id", nullable = false)
    @JsonIgnoreProperties("adoptablePets")
    private PetType petType;

    @OneToOne(mappedBy = "adoptablePet")
    @JsonIgnoreProperties("adoptablePets")
    private AdoptionApplication adoptionApplication;
}