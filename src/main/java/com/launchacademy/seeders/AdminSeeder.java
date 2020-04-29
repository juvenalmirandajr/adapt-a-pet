package com.launchacademy.seeders;

import com.launchacademy.models.Admin;
import com.launchacademy.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder {
    private final AdminRepository adminRepo;

    @Autowired
    public AdminSeeder(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    public void seed() {
        if (adminRepo.count() == 0) {
            Admin admin = new Admin();
            admin.setName("Lucas Green");
            admin.setUsername("root");
            admin.setPassword("root");
            adminRepo.save(admin);
        }
    }
}