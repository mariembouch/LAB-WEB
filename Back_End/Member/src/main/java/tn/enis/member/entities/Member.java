package tn.enis.member.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.enis.member.beans.EvenementBean;
import tn.enis.member.beans.OutilBean;
import tn.enis.member.beans.PublicationBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "role", discriminatorType = DiscriminatorType.STRING, length=10)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public abstract class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Long id;
    @NonNull
    private String cin;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private byte[] photo;
    @NonNull
    private String cv;

    @Transient
    private  Collection<EvenementBean> events;
    @Transient
    Collection<PublicationBean> pubs;
    @Transient
    Collection<OutilBean> outils;

//plus génération des getters et setters

}