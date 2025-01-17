package tn.enis.member.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member_Evenement {
//    @EmbeddedId
//    private Member_Even_Id id;
//    @ManyToOne
//    @MapsId("member_id")
//    private Member member;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id", nullable = false)
    private  Member member;

    @Column(name="evenement_id")
    private Long eventId;
}
