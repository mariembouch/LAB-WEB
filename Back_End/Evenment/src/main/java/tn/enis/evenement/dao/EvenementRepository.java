package tn.enis.evenement.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.evenement.entity.Evenement;

import java.util.Date;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    // Ajoutez des méthodes de recherche personnalisées si nécessaire
    List<Evenement> findByTitre(String titre);
    List<Evenement> findByLieu(String lieu);
    List<Evenement> findByDateDebutBetween(Date startDate, Date endDate);
    List<Evenement> findByDateFinBetween(Date startDate, Date endDate);
}
