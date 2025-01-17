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
public class Member_Outil_Id implements Serializable {
    private Long outil_id;
    private Long user_id;


}
