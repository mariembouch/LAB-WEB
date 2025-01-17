package tn.enis.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.member.entities.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long>
{

    Member findByCin(String cin);
    List<Member> findByNomStartingWith(String caractere);

    List<Member> findByNom(String nom);



}