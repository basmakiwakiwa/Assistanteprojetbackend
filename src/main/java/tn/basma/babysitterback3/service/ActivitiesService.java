package tn.basma.babysitterback3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.Activites;
import tn.basma.babysitterback3.repositories.ActivitesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesService {

    @Autowired
    private ActivitesRepository activitiesRepository;

    public List<Activites> getAllActivities() {
        return activitiesRepository.findAll();
    }

    public Optional<Activites> getActivityById(Long id) {
        return activitiesRepository.findById(id);
    }

    public Activites createActivity(Activites activity) {
        return activitiesRepository.save(activity);
    }

    public Activites updateActivity(Long id, Activites newActivity) {
        Optional<Activites> optionalActivity = activitiesRepository.findById(id);
        if (optionalActivity.isPresent()) {
            Activites activity = optionalActivity.get();
            activity.setDesignation(newActivity.getDesignation());
            activity.setDescription(newActivity.getDescription());
            return activitiesRepository.save(activity);
        } else {
            // Handle error: Activity not found
            return null;
        }
    }

    public void deleteActivity(Long id) {
        activitiesRepository.deleteById(id);
    }
}
