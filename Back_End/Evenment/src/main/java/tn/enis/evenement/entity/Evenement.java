package tn.enis.evenement.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Evenement implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String titre;
    @NonNull @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @NonNull @Temporal(TemporalType.DATE)
    private Date dateFin;

    @NonNull
    private String lieu;
}
