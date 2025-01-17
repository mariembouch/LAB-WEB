package tn.enis.outil.service;



import java.util.List;
import tn.enis.outil.entities.Outil;

public interface IOutilService {

    public Outil addOutil(Outil outil);
    public void deleteOutil(Long id);
    public Outil updateOutil(Outil outil);
    public Outil findOutil(Long id);
    public List<Outil> findAll();
    public Outil findBySource(String source);
    public List<Outil> findOutilByNom(String nom);
    public List<Outil> findBySourceStartingWith(String source);
}
