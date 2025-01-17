package tn.enis.evenement.service;

import tn.enis.evenement.entity.Evenement;

import java.util.Date;
import java.util.List;

public interface IEvenementService {

    //crud
    public Evenement addEvenement(Evenement e);
    public void deleteEvenement(Long id) ;
    public Evenement updateEvenement(Evenement e) ;
    public Evenement findEvenement(Long id) ;
    public List<Evenement> findAll();
    List<Evenement> findByTitre(String titre);
    List<Evenement> findByLieu(String lieu);
    List<Evenement> findByDateDebutBetween(Date startDate, Date endDate);
    List<Evenement> findByDateFinBetween(Date startDate, Date endDate);

    int[] getFullYearsEvents(int startYear, int endYear);

}
