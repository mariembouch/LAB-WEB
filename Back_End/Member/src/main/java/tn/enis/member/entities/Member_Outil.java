package tn.enis.member.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.enis.member.beans.OutilBean;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member_Outil {
    @EmbeddedId
    private Member_Outil_Id id;
    @ManyToOne
    @MapsId("user_id")
    private Member user;

}