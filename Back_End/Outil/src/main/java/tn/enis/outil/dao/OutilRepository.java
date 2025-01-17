package tn.enis.outil.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import tn.enis.outil.entities.Outil;


@RepositoryRestController
public interface OutilRepository extends JpaRepository<Outil, Long> {
  

    List<Outil> findByNom(String nom);

    // Find an Outil by its source
    Outil findBySource(String source);
   
	public List<Outil> findBySourceStartingWith(String source);
    


}
