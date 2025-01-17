package tn.enis.member.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutilBean {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nom")
    private String nom;
    @JsonProperty("date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonProperty("source")
    private String source;

}
