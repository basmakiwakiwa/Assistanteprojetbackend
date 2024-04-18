package tn.basma.babysitterback3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Activites;
import tn.basma.babysitterback3.service.ActivitiesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivitiesController {

    @Autowired
    private ActivitiesService activitiesService;

    @GetMapping
    public ResponseEntity<List<Activites>> getAllActivities() {
        List<Activites> activities = activitiesService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activites> getActivityById(@PathVariable("id") Long id) {
        Optional<Activites> activity = activitiesService.getActivityById(id);
        return activity.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Activites> createActivity(@RequestBody Activites activity) {
        Activites createdActivity = activitiesService.createActivity(activity);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activites> updateActivity(@PathVariable("id") Long id, @RequestBody Activites activity) {
        Activites updatedActivity = activitiesService.updateActivity(id, activity);
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
