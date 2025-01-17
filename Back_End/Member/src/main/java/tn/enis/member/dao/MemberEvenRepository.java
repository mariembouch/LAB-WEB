package tn.enis.member.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Member_Even_Id;
import tn.enis.member.entities.Member_Evenement;


import java.util.List;

public interface MemberEvenRepository extends
        JpaRepository<Member_Evenement, Long> {
    List<Member_Evenement> findByMember(Member member);
    List<Member_Evenement> findByEventId(Long eventId);


    @Transactional
    void deleteAllByMember(Member member);

    @Transactional
    void deleteAllByEventId(Long id);
}
