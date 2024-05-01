package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.service.ListeParent;

import java.util.List;

@RequestMapping("/listeparent")

@RestController
public class ListeParentControlleur {

    @Autowired
    ListeParent listParentServ;




    @DeleteMapping(value="/deleteuser/{user_id}")
    public void deleteuser(@PathVariable Long user_id)
    {
        listParentServ.deleteUser(user_id);
    }



    @GetMapping("/affichelisteParent")
    public List<Parent> getAllParent()
    {
        return  listParentServ.getAllParent();
    }

    @PutMapping(value="/updateuser/{user_id}")
    public Parent updateParent(@PathVariable Long user_id , Parent parent )
    {
       return  listParentServ.updateParent(user_id,parent);
    }


}
