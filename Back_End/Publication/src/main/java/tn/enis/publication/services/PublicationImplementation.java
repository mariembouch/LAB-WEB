package tn.enis.publication.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.publication.dao.PublicationRepository;
import tn.enis.publication.entities.Publication;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Service
public class PublicationImplementation implements IPublicationService{


    private PublicationRepository publicationRepository;

    @Override
    public Publication addPublication(Publication m) {
        return publicationRepository.save(m);
    }

    @Override
    public void deletePublication(Long id) {
        Publication publication = publicationRepository.findById(id).get();
        publicationRepository.delete(publication);
    }

    @Override
    public Publication updatePublication(Publication p) {
        return publicationRepository.saveAndFlush(p);
    }

    @Override
    public Publication findPublication(Long id) {
        return publicationRepository.findById(id).get();
    }

    @Override
    public List<Publication> findAll() {
        return publicationRepository.findAll();
    }

    @Override
    public List<Publication> findByTitreStartingWith(String titre) {
        return publicationRepository.findByTitreStartingWith(titre);
    }

    @Override
    public List<Publication> findByTitre(String titre) {
        return publicationRepository.findByTitre(titre);
    }

    @Override
    public List<Publication> findByType(String type) {
        return publicationRepository.findByType(type);
    }

    @Override
    public List<Publication> findByDateBetween(Date date1, Date date2) {
        return publicationRepository.findByDateBetween(date1, date2);
    }


}
