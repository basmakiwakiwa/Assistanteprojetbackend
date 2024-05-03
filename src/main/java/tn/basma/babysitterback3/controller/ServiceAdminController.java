package tn.basma.babysitterback3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Services;
import tn.basma.babysitterback3.service.ActivitiesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/activities")
public class ServiceAdminController {

    @Autowired
    private ActivitiesService activitiesService;

    @GetMapping("/all")
    public ResponseEntity<List<Services>> getAllActivities() {
        List<Services> activities = activitiesService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getActivityById(@PathVariable("id") Long id) {
        Optional<Services> activity = activitiesService.getActivityById(id);
        return activity.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Services> createActivity(@RequestBody Services activity) {
        Services createdActivity = activitiesService.createActivity(activity);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Services> updateActivity(@PathVariable("id") Long id, @RequestBody Services activity) {
        Services updatedActivity = activitiesService.updateActivity(id, activity);
        return updatedActivity != null ?
                new ResponseEntity<>(updatedActivity, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable("id") Long id) {
        activitiesService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
