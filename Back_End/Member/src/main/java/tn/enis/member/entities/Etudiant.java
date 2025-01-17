package tn.enis.member.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("etudiant")
public class Etudiant extends Member{

    @ManyToOne
    private EnseignantChercheur encadrant;

    @NonNull
    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    private String diplome;

    private  String sujet ;

    @Builder
    public Etudiant( String cin, String nom, String prenom, Date dateNaissance, String cv,
                      Date dateInscription, String sujet, String
                             diplome, EnseignantChercheur encadrant) {
        super( cin, nom, prenom, dateNaissance, cv);
        this.dateInscription = dateInscription;
        this.sujet = sujet;
        this.diplome = diplome;
        this.encadrant = encadrant;
    }
}
