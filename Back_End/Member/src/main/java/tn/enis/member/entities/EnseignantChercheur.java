package tn.enis.member.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("enseignant")
public class EnseignantChercheur extends Member{

    @NonNull
    private String grade;

    @NonNull
    private String etablissement;

    @Builder
    public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String cv,
                               String grade ,String  etablissement ){

        super( cin, nom, prenom, dateNaissance, cv);
        this.grade = grade;
        this.etablissement =etablissement ;


    }


}
