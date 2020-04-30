package com.launchacademy.repositories;

import com.launchacademy.models.AdoptablePet;
import com.launchacademy.models.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptablePetRepository extends CrudRepository<AdoptablePet, Integer> {
    List<AdoptablePet> findByPetType(PetType petType);
}
