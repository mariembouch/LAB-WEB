package tn.enis.outil.entities;

import java.io.Serializable;
import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Outil{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nom;

    @Temporal(TemporalType.DATE)
    private Date date;
    
    @NonNull
    private String source;



}
