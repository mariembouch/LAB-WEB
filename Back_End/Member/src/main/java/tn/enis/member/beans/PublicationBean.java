package tn.enis.member.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublicationBean {
    // Fields

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("titre")
    private String titre;

    @JsonProperty("lien")
    private String lien;

    @JsonProperty("date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonProperty("sourcepdf")
    private String sourcepdf;
}