package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.dto.EmailDetails;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.entites.Rdv;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.AssistanteRepo;
import tn.basma.babysitterback3.repositories.ParentRepo;
import tn.basma.babysitterback3.repositories.RdvParentRepo;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class RdvServiceImpl implements RdvService {

    @Autowired
    private RdvParentRepo rdvRepository;
    @Autowired
    private ParentRepo parentRepo;
    @Autowired
    private AssistanteRepo assistanteRepo ;
    @Autowired
    private  EmailService emailService;

    @Override
    public Rdv saveRdvWithParent(Long id,Long idauxiliaires, Rdv rdv) {
        Optional<Parent> parentOptional = parentRepo.findById(id);
        Optional<auxiliairesdevie> auxiliairesOptional =assistanteRepo.findById(idauxiliaires);

        if (parentOptional.isPresent()) {
            Parent parent = parentOptional.get();
            rdv.setParent(parent);
            EmailDetails emaildetails = new EmailDetails();
            emaildetails.setTo(auxiliairesOptional.get().getEmail());
            emaildetails.setSubject("demande rdv");
            emaildetails.setMessageBody(rdv.getDescription());
            emailService.sendSimpleMail(emaildetails);
            return rdvRepository.save(rdv);
        }
        return null;
    }




    @Override
    public List<Rdv> getAllRdvsByParentId(Long id) {
        // Récupérer tous les rendez-vous associés à un parent spécifique
        return rdvRepository.findByParentId(id);
    }






}
