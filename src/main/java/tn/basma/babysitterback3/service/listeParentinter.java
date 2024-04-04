package tn.basma.babysitterback3.service;


import tn.basma.babysitterback3.entites.Parent;


import java.util.List;

public interface listeParentinter {

//hthya suprimer parent
    public void deleteUser(Long iduser);


//hthya affiche parent
    public List<Parent> getAllParent();



    public Parent updateParent (Long iduser, Parent parent);



}
