package tn.enis.member.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Member_Pub_Id;
import tn.enis.member.entities.Member_Publication;

import java.util.List;

public interface MemberPubRepository extends
        JpaRepository<Member_Publication, Member_Pub_Id> {
    List<Member_Publication> findByAuteur(Member auteur);
    @Transactional
    void deleteAllByAuteur(Member auteur);
}