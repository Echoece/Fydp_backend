package com.example.demo.controller;

import com.example.demo.entity.Pesticide;
import com.example.demo.entity.dto.PesticideDTO;
import com.example.demo.repo.PesticideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pesticide")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class PesticideController {
    private final PesticideRepository pesticideRepository;

    @GetMapping
    public List<Pesticide> getAll(){
	return pesticideRepository.findAll();
    }

    @PostMapping("/suggestion")
    public Pesticide getSuggestion(@RequestBody PesticideDTO pesticideDTO){
        return pesticideRepository.getByCropNameAndProblemName(pesticideDTO.getCropName(), pesticideDTO.getProblemName())
                        .orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Pesticide create(@RequestBody Pesticide pesticide){
	return pesticideRepository.save(pesticide);
    }

    @PutMapping
    public Pesticide update(@RequestBody Pesticide pesticide){
	return pesticideRepository.save(pesticide);
    }

    @DeleteMapping
    public void delete(@RequestBody Pesticide pesticide){
	pesticideRepository.delete(pesticide);
    }
}
