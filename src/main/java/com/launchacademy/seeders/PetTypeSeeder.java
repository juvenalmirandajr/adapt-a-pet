package com.launchacademy.seeders;

import com.launchacademy.models.PetType;
import com.launchacademy.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetTypeSeeder {
    private final PetTypeRepository petTypeRepo;

    @Autowired
    public PetTypeSeeder(PetTypeRepository petTypeRepo) {
        this.petTypeRepo = petTypeRepo;
    }

    public void seed() {
        if (petTypeRepo.count() == 0) {
            PetType guinea = new PetType();
            guinea.setType("guinea pig");
            guinea.setDescription("Domesticated rodent");
            petTypeRepo.save(guinea);

            PetType reptile = new PetType();
            reptile.setType("reptile");
            reptile.setDescription("Domesticated questionable enemy");
            petTypeRepo.save(reptile);
        }
    }
}
