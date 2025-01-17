package tn.enis.publication.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.enis.publication.entities.Publication;
import tn.enis.publication.services.IPublicationService;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
public class PublicationController {

    IPublicationService publicationService;


    @PostMapping(value="/publications/create")
    public Publication addPublication(@RequestBody Publication m) {
        return publicationService.addPublication(m);
    }

    @DeleteMapping(value="/publications/{id}/delete")
    public void deletePublication(@PathVariable Long id) {
        publicationService.deletePublication(id);
    }

    @PutMapping(value="/publications/{id}/update")
    public Publication updatePublication(@RequestBody Publication p) {
        return publicationService.updatePublication(p);
    }

    @GetMapping(value="/publications/{id}")
    public Publication findPublication(@PathVariable Long id) {
        return publicationService.findPublication(id);
    }


    @GetMapping(value="/publications")
    public List<Publication> findAll() {
        return publicationService.findAll();
    }


    @GetMapping(value="/publications/starts-with-titre")
    public List<Publication> findByTitreStartingWith(@RequestParam String titre) {
        return publicationService.findByTitreStartingWith(titre);
    }

    @GetMapping(value="/publications/titre")
    public List<Publication> findByTitre(@RequestParam String titre) {
        return publicationService.findByTitre(titre);
    }

    @GetMapping(value="/publications/type")
    public List<Publication> findByType(@RequestParam String type) {
        return publicationService.findByType(type);
    }

    @GetMapping(value="/publications/between-dates")
    public List<Publication> findByDateBetween(@RequestParam Date date1,@RequestParam Date date2) {
        return publicationService.findByDateBetween(date1, date2);
    }
}
