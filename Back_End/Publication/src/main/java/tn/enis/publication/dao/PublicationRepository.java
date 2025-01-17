package tn.enis.publication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import tn.enis.publication.entities.Publication;

import java.util.Date;
import java.util.List;


@RepositoryRestController
public interface PublicationRepository extends JpaRepository<Publication,Long>
{
    public List<Publication> findByTitreStartingWith(String titre);
    public List<Publication> findByTitre(String titre);
    public List<Publication> findByType(String type);
    List<Publication> findByDateBetween(Date date1, Date date2);
}

