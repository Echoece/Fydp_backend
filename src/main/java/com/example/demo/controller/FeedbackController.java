package com.example.demo.controller;

import com.example.demo.entity.Feedback;
import com.example.demo.repo.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/feedback")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeedbackController {
    private final FeedbackRepository feedbackRepository;

    @GetMapping
    public List<Feedback> getAll(){
	return feedbackRepository.findAll();
    }

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback){
	return feedbackRepository.save(feedback);
    }

}
