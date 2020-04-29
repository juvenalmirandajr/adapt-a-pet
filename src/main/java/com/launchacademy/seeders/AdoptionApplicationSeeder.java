package com.launchacademy.seeders;

import com.launchacademy.models.AdoptablePet;
import com.launchacademy.models.AdoptionApplication;
import com.launchacademy.repositories.AdoptablePetRepository;
import com.launchacademy.repositories.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptionApplicationSeeder {
    private final AdoptionApplicationRepository adoptionApplicationRepo;
    private final AdoptablePetRepository adoptablePetRepo;

    @Autowired
    public AdoptionApplicationSeeder(AdoptionApplicationRepository adoptionApplicationRepo, AdoptablePetRepository adoptablePetRepo) {
        this.adoptionApplicationRepo = adoptionApplicationRepo;
        this.adoptablePetRepo = adoptablePetRepo;
    }

    public void seed() {
        if (adoptionApplicationRepo.count() == 0) {
            AdoptionApplication adoptionApp = new AdoptionApplication();
            adoptionApp.setName("Robert");
            adoptionApp.setPhoneNumber("617-896-4573");
            adoptionApp.setEmail("robertm@gmail.com");
            adoptionApp.setHomeStatus("Rent");
            adoptionApp.setApplicationStatus("Pending");
            adoptionApp.setAdoptablePet(adoptablePetRepo.findById(1).orElse(new AdoptablePet()));
            adoptionApplicationRepo.save(adoptionApp);

            adoptionApp = new AdoptionApplication();
            adoptionApp.setName("Erica");
            adoptionApp.setPhoneNumber("617-390-2820");
            adoptionApp.setEmail("esmith@gmail.com");
            adoptionApp.setHomeStatus("Own");
            adoptionApp.setApplicationStatus("Pending");
            adoptionApp.setAdoptablePet(adoptablePetRepo.findById(3).orElse(new AdoptablePet()));
            adoptionApplicationRepo.save(adoptionApp);

            adoptionApp = new AdoptionApplication();
            adoptionApp.setName("Franklin");
            adoptionApp.setPhoneNumber("617-893-0298");
            adoptionApp.setEmail("franklinj@gmail.com");
            adoptionApp.setHomeStatus("Rent");
            adoptionApp.setApplicationStatus("Pending");
            adoptionApp.setAdoptablePet(adoptablePetRepo.findById(2).orElse(new AdoptablePet()));
            adoptionApplicationRepo.save(adoptionApp);

            adoptionApp = new AdoptionApplication();
            adoptionApp.setName("Nancy");
            adoptionApp.setPhoneNumber("617-209-7654");
            adoptionApp.setEmail("nlee@gmail.com");
            adoptionApp.setHomeStatus("Rent");
            adoptionApp.setApplicationStatus("Pending");
            adoptionApp.setAdoptablePet(adoptablePetRepo.findById(4).orElse(new AdoptablePet()));
            adoptionApplicationRepo.save(adoptionApp);
        }

    }
}
