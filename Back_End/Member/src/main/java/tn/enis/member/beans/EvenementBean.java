package tn.enis.member.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.NonNull;

import java.util.Date;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvenementBean {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("titre")
    private String titre;
    @JsonProperty("dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @JsonProperty("dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JsonProperty("lieu")
    private String lieu;
}
