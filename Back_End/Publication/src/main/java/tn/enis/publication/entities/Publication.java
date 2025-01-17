package tn.enis.publication.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.net.Proxy;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Long id;

    @NonNull
    private String type;
    @NonNull
    private String titre;
    @NonNull
    private String lien;

    @Temporal(TemporalType.DATE)
    @NonNull
    private Date date;
    @NonNull
    private String sourcepdf;


}
