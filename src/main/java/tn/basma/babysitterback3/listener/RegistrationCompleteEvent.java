package tn.basma.babysitterback3.listener;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import tn.basma.babysitterback3.entites.User;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }


}