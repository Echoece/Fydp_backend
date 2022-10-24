package com.example.demo.repo;

import com.example.demo.entity.Pesticide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PesticideRepository extends JpaRepository<Pesticide,Long> {
    Optional<Pesticide> getByCropNameAndProblemName(String cropName, String problemName);
}
