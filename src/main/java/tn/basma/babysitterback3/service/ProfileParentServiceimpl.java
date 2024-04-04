package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.repositories.ParentRepo;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileParentServiceimpl  implements  ProfileParentServices   {

    @Autowired
    public ParentRepo parentrepo;

    @Override
    public Optional<Parent> getParent(String email) {
        return parentrepo.findByEmail(email);
    }

}
