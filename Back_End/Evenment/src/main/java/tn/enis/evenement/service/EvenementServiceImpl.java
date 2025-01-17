package tn.enis.evenement.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.evenement.dao.EvenementRepository;
import tn.enis.evenement.entity.Evenement;


import java.util.*;

import java.util.Date;
import java.util.List;


@Service
public class EvenementServiceImpl implements IEvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Override
    public Evenement addEvenement(Evenement e){
        evenementRepository.save(e);
        return e;
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }

    @Override
    public Evenement updateEvenement(Evenement e){
        return  evenementRepository.saveAndFlush(e);
    }

    @Override
    public Evenement findEvenement(Long id) {
        return evenementRepository.findById(id).get();
    }

    @Override
    public List<Evenement> findAll(){
        return evenementRepository.findAll();
    }

    @Override
    public List<Evenement> findByTitre(String titre) {
        return evenementRepository.findByTitre(titre);
    }

    @Override
    public List<Evenement> findByLieu(String lieu) {
        return evenementRepository.findByLieu(lieu);
    }

    @Override
    public List<Evenement> findByDateDebutBetween(Date startDate, Date endDate) {
        return evenementRepository.findByDateDebutBetween(startDate, endDate);
    }

    @Override
    public List<Evenement> findByDateFinBetween(Date startDate, Date endDate) {
        return evenementRepository.findByDateFinBetween(startDate, endDate);
    }


    @Override
    public int[] getFullYearsEvents(int startYear, int endYear) {
        int[] fullYearsEvents = {0,0,0,0,0,0,0,0,0,0,0,0};

        for (int y = startYear-1900; y <= endYear-1900; y++) {


            for (int m = 0; m < 12; m++) {
                // Get the last day of the month
                Calendar calendar = new GregorianCalendar(y, m , 1);
                int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                Date date1 = new Date(y, m, 1);
                Date date2 = new Date(y, m, lastDay);
                // Find events for the month
                List<Evenement> events = evenementRepository.findByDateDebutBetween(
                        date1,
                        date2
                );
                System.out.print(date1.toString()+ " "+ date2.toString() + " ");
                // Accumulate the number of events for the month
                fullYearsEvents[m]+=events.size();

            }


        }

        return fullYearsEvents;
    }

}
