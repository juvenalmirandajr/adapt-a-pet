package com.launchacademy.repositories;

import com.launchacademy.models.SurrenderApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurrenderApplicationRepository extends CrudRepository<SurrenderApplication, Integer> {
}
