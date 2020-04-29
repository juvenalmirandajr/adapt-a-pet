package com.launchacademy.seeders;

import com.launchacademy.models.AdoptablePet;
import com.launchacademy.models.AdoptionApplication;
import com.launchacademy.models.PetType;
import com.launchacademy.models.SurrenderApplication;
import com.launchacademy.repositories.AdoptablePetRepository;
import com.launchacademy.repositories.AdoptionApplicationRepository;
import com.launchacademy.repositories.PetTypeRepository;
import com.launchacademy.repositories.SurrenderApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdoptablePetSeeder implements CommandLineRunner {
    private final AdoptablePetRepository adoptablePetRepo;
    private final PetTypeRepository petTypeRepo;
    private final AdoptionApplicationRepository adoptionApplicationRepo;
    private final SurrenderApplicationRepository surrenderApplicationRepo;

    @Autowired
    public AdoptablePetSeeder(AdoptablePetRepository adoptablePetRepo,
                              PetTypeRepository petTypeRepo,
                              AdoptionApplicationRepository adoptionApplicationRepo,
                              SurrenderApplicationRepository surrenderApplicationRepo) {
        this.adoptablePetRepo = adoptablePetRepo;
        this.petTypeRepo = petTypeRepo;
        this.adoptionApplicationRepo = adoptionApplicationRepo;
        this.surrenderApplicationRepo = surrenderApplicationRepo;
    }

    @Override
    public void run(String... args) throws Exception {
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

        if (adoptablePetRepo.count() == 0) {
            AdoptablePet adoptablePet = new AdoptablePet();
            adoptablePet.setName("Helena");
            adoptablePet.setImgUrl("https://www.reptilecentre.com/images/wmfixed/Reptile/frozen-guinea-pig-v1-495-495.jpg?v=2");
            adoptablePet.setAge(3);
            adoptablePet.setVaccinationStatus(true);
            adoptablePet.setAdoptionStory("Is a sweet guineapig that loves belly rubs.");
            adoptablePet.setAdoptionStatus("Pending");
            adoptablePet.setPetType(petTypeRepo.findById(1).get());
            adoptablePetRepo.save(adoptablePet);

            adoptablePet = new AdoptablePet();
            adoptablePet.setName("Artemis");
            adoptablePet.setImgUrl("https://lafeber.com/vet/wp-content/uploads/Veiled-chameleon-by-Mrs-Logic-cropped-square.jpg");
            adoptablePet.setAge(5);
            adoptablePet.setVaccinationStatus(false);
            adoptablePet.setAdoptionStory("Is a chameleon that gets excited at the sight of lettuce.");
            adoptablePet.setAdoptionStatus("Pending");
            adoptablePet.setPetType(petTypeRepo.findById(2).orElse(new PetType()));
            adoptablePetRepo.save(adoptablePet);

            adoptablePet = new AdoptablePet();
            adoptablePet.setName("Rocky");
            adoptablePet.setImgUrl("https://cdn.mos.cms.futurecdn.net/gJJFamQca86CibEeDmegk-1024-80.jpg");
            adoptablePet.setAge(7);
            adoptablePet.setVaccinationStatus(false);
            adoptablePet.setAdoptionStory("Is a ornery guineapig that hates belly rubs.");
            adoptablePet.setAdoptionStatus("'Pending'");
            adoptablePet.setPetType(petTypeRepo.findById(1).orElse(new PetType()));
            adoptablePetRepo.save(adoptablePet);

            adoptablePet = new AdoptablePet();
            adoptablePet.setName("Harry");
            adoptablePet.setImgUrl("https://img1.grunge.com/img/gallery/the-truth-about-why-there-arent-snakes-in-ireland/intro-1547479326.jpg");
            adoptablePet.setAge(2);
            adoptablePet.setVaccinationStatus(true);
            adoptablePet.setAdoptionStory("Is a snake with a huge appetite for bunnies.");
            adoptablePet.setAdoptionStatus("Pending");
            adoptablePet.setPetType(petTypeRepo.findById(2).orElse(new PetType()));
            adoptablePetRepo.save(adoptablePet);

            adoptablePet = new AdoptablePet();
            adoptablePet.setName("Sticky");
            adoptablePet.setImgUrl("https://live.staticflickr.com/8576/15166690374_6dcf167afa_b.jpg");
            adoptablePet.setAge(1);
            adoptablePet.setVaccinationStatus(true);
            adoptablePet.setAdoptionStory("This guy loves crickets");
            adoptablePet.setAdoptionStatus("Pending");
            adoptablePet.setPetType(petTypeRepo.findById(2).orElse(new PetType()));
            adoptablePetRepo.save(adoptablePet);

            adoptablePet = new AdoptablePet();
            adoptablePet.setName("Pancake");
            adoptablePet.setImgUrl("https://i.pinimg.com/originals/f8/bc/80/f8bc8082646c8bc7e7a87b9d6b02543f.jpg");
            adoptablePet.setAge(4);
            adoptablePet.setVaccinationStatus(true);
            adoptablePet.setAdoptionStory("This guy loves to lounge around");
            adoptablePet.setAdoptionStatus("Pending");
            adoptablePet.setPetType(petTypeRepo.findById(1).orElse(new PetType()));
            adoptablePetRepo.save(adoptablePet);
        }

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

        if (adoptionApplicationRepo.count() == 0) {
            AdoptionApplication adoptionApp =  new AdoptionApplication();
            adoptionApp.setName("Robert");
            adoptionApp.setPhoneNumber("617-896-4573");
            adoptionApp.setEmail("robertm@gmail.com");
            adoptionApp.setHomeStatus("Rent");
            adoptionApp.setApplicationStatus("Pending");
            adoptionApp.setAdoptablePet(adoptablePetRepo.findById(1).orElse(new AdoptablePet()));
            adoptionApplicationRepo.save(adoptionApp);

            adoptionApp =  new AdoptionApplication();
            adoptionApp.setName("Erica");
            adoptionApp.setPhoneNumber("617-390-2820");
            adoptionApp.setEmail("esmith@gmail.com");
            adoptionApp.setHomeStatus("Own");
            adoptionApp.setApplicationStatus("Pending");
            adoptionApp.setAdoptablePet(adoptablePetRepo.findById(3).orElse(new AdoptablePet()));
            adoptionApplicationRepo.save(adoptionApp);

            adoptionApp =  new AdoptionApplication();
            adoptionApp.setName("Franklin");
            adoptionApp.setPhoneNumber("617-893-0298");
            adoptionApp.setEmail("franklinj@gmail.com");
            adoptionApp.setHomeStatus("Rent");
            adoptionApp.setApplicationStatus("Pending");
            adoptionApp.setAdoptablePet(adoptablePetRepo.findById(2).orElse(new AdoptablePet()));
            adoptionApplicationRepo.save(adoptionApp);

            adoptionApp =  new AdoptionApplication();
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
