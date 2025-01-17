package tn.enis.member.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member_Even_Id implements Serializable {
    private Long evenement_id;
    private Long member_id;
}
