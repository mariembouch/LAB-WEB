package tn.enis.member.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;


import java.util.List;

@RepositoryRestController

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String diplome);
    List<Etudiant> findEtudiantsByEncadrant(EnseignantChercheur enseignantChercheur);


}
