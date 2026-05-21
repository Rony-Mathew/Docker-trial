package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DockerController {

    @Autowired
    private HitRepository hitRepository;

    @GetMapping("/")
    public String home() {
        // Save a new page view entry into H2 database
        hitRepository.save(new Hit());

        // Count total entries
        long count = hitRepository.count();

        return "<h1>Hello from Spring Boot & Docker!</h1>" +
                "<p>This page has been viewed " + count + " times using an H2 Database.</p>";
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> status = new HashMap<>();
        status.setStatus("UP");
        status.put("timestamp", System.currentTimeMillis());
        return status;
    }
}