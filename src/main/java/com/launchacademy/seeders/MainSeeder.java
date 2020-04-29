package com.launchacademy.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
    private final PetTypeSeeder petTypeSeeder;
    private final AdoptablePetSeeder adoptablePetSeeder;
    private final SurrenderApplicationSeeder surrenderApplicationSeeder;
    private final AdoptionApplicationSeeder adoptionApplicationSeeder;
    private final AdminSeeder adminSeeder;

    @Autowired
    public MainSeeder(PetTypeSeeder petTypeSeeder, AdoptablePetSeeder adoptablePetSeeder, SurrenderApplicationSeeder surrenderApplicationSeeder, AdoptionApplicationSeeder adoptionApplicationSeeder, AdminSeeder adminSeeder) {
        this.petTypeSeeder = petTypeSeeder;
        this.adoptablePetSeeder = adoptablePetSeeder;
        this.surrenderApplicationSeeder = surrenderApplicationSeeder;
        this.adoptionApplicationSeeder = adoptionApplicationSeeder;
        this.adminSeeder = adminSeeder;
    }

    @Override
    public void run(String... args) throws Exception {
        petTypeSeeder.seed();
        adoptablePetSeeder.seed();
        surrenderApplicationSeeder.seed();
        adoptionApplicationSeeder.seed();
        adminSeeder.seed();
    }
}
