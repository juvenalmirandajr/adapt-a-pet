package com.launchacademy.seeders;

import com.launchacademy.models.PetType;
import com.launchacademy.models.SurrenderApplication;
import com.launchacademy.repositories.PetTypeRepository;
import com.launchacademy.repositories.SurrenderApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurrenderApplicationSeeder {
    private final SurrenderApplicationRepository surrenderApplicationRepo;
    private final PetTypeRepository petTypeRepo;

    @Autowired
    public SurrenderApplicationSeeder(SurrenderApplicationRepository surrenderApplicationRepo, PetTypeRepository petTypeRepo) {
        this.surrenderApplicationRepo = surrenderApplicationRepo;
        this.petTypeRepo = petTypeRepo;
    }

    public void seed() {
        if (surrenderApplicationRepo.count() == 0) {
            SurrenderApplication surrenderApp = new SurrenderApplication();
            surrenderApp.setName("John");
            surrenderApp.setPhoneNumber("617-882-5647");
            surrenderApp.setEmail("johnm@gmail.com");
            surrenderApp.setPetName("Bob");
            surrenderApp.setPetAge(2);
            surrenderApp.setPetType(petTypeRepo.findById(2).orElse(new PetType()));
            surrenderApp.setImgUrl("https://1.bp.blogspot.com/-8kABMMyDw_E/UCeYS-CqiRI/AAAAAAAAEmI/09PDWJEOToM/s1600/hd-snake-wallpaper-with-a-attacking-green-snake-wallpapers-backgrounds.jpg");
            surrenderApp.setVaccinationStatus(false);
            surrenderApp.setApplicationStatus("Pending");
            surrenderApplicationRepo.save(surrenderApp);

            surrenderApp = new SurrenderApplication();
            surrenderApp.setName("Jessica");
            surrenderApp.setPhoneNumber("617-784-3921");
            surrenderApp.setEmail("jmatos@gmail.com");
            surrenderApp.setPetName("Tom");
            surrenderApp.setPetAge(8);
            surrenderApp.setPetType(petTypeRepo.findById(1).orElse(new PetType()));
            surrenderApp.setImgUrl("https://animals.sandiegozoo.org/sites/default/files/2019-04/animals_guineapigs.jpg");
            surrenderApp.setVaccinationStatus(true);
            surrenderApp.setApplicationStatus("Pending");
            surrenderApplicationRepo.save(surrenderApp);
        }

    }
}
