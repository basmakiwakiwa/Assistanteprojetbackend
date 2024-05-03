package tn.basma.babysitterback3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.Services;
import tn.basma.babysitterback3.repositories.ServiceAssistanteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesService {
//hthya 5as b mta3 admin crud 3adiin
    @Autowired
    private ServiceAssistanteRepository activitiesRepository;

    public List<Services> getAllActivities() {
        return activitiesRepository.findAll();
    }

    public Optional<Services> getActivityById(Long id) {
        return activitiesRepository.findById(id);
    }

    public Services createActivity(Services activity) {
        return activitiesRepository.save(activity);
    }

    public Services updateActivity(Long id, Services newActivity) {
        Optional<Services> optionalActivity = activitiesRepository.findById(id);
        if (optionalActivity.isPresent()) {
            Services activity = optionalActivity.get();
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
