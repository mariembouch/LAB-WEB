package tn.enis.evenement.controller;




import jakarta.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.evenement.entity.Evenement;
import tn.enis.evenement.service.EvenementServiceImpl;
import tn.enis.evenement.service.IEvenementService;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EvenementRestController {

    @Autowired

    IEvenementService evenementService;


    @PostMapping("/events/create")
    public Evenement addEvenement(@RequestBody Evenement evenement) {
       return evenementService.addEvenement(evenement);

    }


    @DeleteMapping("/events/{id}/delete")
    public void deleteEvenement(@PathVariable Long id) {
        evenementService.deleteEvenement(id);
    }


    @PutMapping("/events/{id}/update")
    public Evenement updateEvenement(@RequestBody Evenement e) {
        return evenementService.updateEvenement(e);
    }


    @GetMapping("/events/{id}")
    public Evenement findEvenement(@PathVariable  Long id) {
        return evenementService.findEvenement(id);
    }


    @GetMapping("/events")
    public List<Evenement> findAll() {
        return evenementService.findAll();
    }


    @GetMapping("/events/search/titre")
    public List<Evenement> findByTitre(@RequestParam String titre) {
        return evenementService.findByTitre(titre);
    }


    @GetMapping("/events/search/lieu")
    public List<Evenement> findByLieu(@RequestParam String lieu) {
        return evenementService.findByLieu(lieu);
    }


    @GetMapping("/events/search/datedebut")
    public List<Evenement> findByDateDebutBetween(@RequestParam Date startDate,@RequestParam Date endDate) {
        return evenementService.findByDateDebutBetween(startDate, endDate);
    }


    @GetMapping("/events/search/datefin")
    public List<Evenement> findByDateFinBetween(@RequestParam Date startDate,@RequestParam Date endDate) {
        return evenementService.findByDateFinBetween(startDate, endDate);
    }


    @GetMapping("/events/full-years-events/{startYear}/{endYear}")
    public int[] getFullYearsEvents(
            @PathVariable(name = "startYear") int startYear,
            @PathVariable(name = "endYear") int endYear
    ) {
        return evenementService.getFullYearsEvents(startYear, endYear);
    }

}
