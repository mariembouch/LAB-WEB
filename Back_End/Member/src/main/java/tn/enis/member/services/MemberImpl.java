package tn.enis.member.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.member.beans.EvenementBean;
import tn.enis.member.beans.OutilBean;
import tn.enis.member.beans.PublicationBean;
import tn.enis.member.dao.*;
import tn.enis.member.entities.*;
import tn.enis.member.proxies.EvenementProxyService;
import tn.enis.member.proxies.OutilProxyService;
import tn.enis.member.proxies.PublicationProxyService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class MemberImpl implements IMemberService {
    MemberRepository memberRepository;
    EtudiantRepository etudiantRepository;
    EnseignantChercheurRepository enseignantChercheurRepository;

    MemberPubRepository memberPubRepository;
    PublicationProxyService pubProxy;

    MemberEvenRepository memberEvenRepository;
    EvenementProxyService evenProxy;

    MemberOutilRepository memberOutilRepository;
    OutilProxyService outilProxy;

    public Member addMember(Member m) {
        memberRepository.save(m);
        return m;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public Member updateMember(Member m) {
        return memberRepository.saveAndFlush(m);
    }

    public Member findMember(Long id) {
        return (Member) memberRepository.findById(id).get();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findByCin(String cin) {
        return memberRepository.findByCin(cin);
    }


    public List<Member> findByNom(String nom) {
        return memberRepository.findByNom(nom);
    }

    public List<Etudiant> findByDiplome(String diplome) {
        return etudiantRepository.findByDiplome(diplome);
    }

    public List<EnseignantChercheur> findByGrade(String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }

    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }


    @Override
    public List<Etudiant> findByEncadrant(EnseignantChercheur enseignantChercheur) {

        return etudiantRepository.findEtudiantsByEncadrant(enseignantChercheur);
    }



    @Override
    public void affectEtudiantToEncadrant(Long id_etd, Long id_ens) {
        Etudiant etd = etudiantRepository.findById(id_etd).get();
        EnseignantChercheur ens = enseignantChercheurRepository.findById(id_ens).get();
        etd.setEncadrant(ens);
        etudiantRepository.save(etd);
    }

    @Override
    public void affecterauteurTopublication(Long idauteur, Long idpub) {
        Member mbr = memberRepository.findById(idauteur).get();
        Member_Publication mbs = new Member_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Member_Pub_Id(idpub, idauteur));
        memberPubRepository.save(mbs);
    }

    @Override
    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs = new ArrayList<PublicationBean>();
        Member auteur = memberRepository.findById(idauteur).get();
        List<Member_Publication>
                idpubs = memberPubRepository.findByAuteur(auteur);
        idpubs.forEach(s -> {
                    System.out.println(s);
                    pubs.add(pubProxy.findPublicationById(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }
    @Override
    public void affecterUserToOutil(Long userid, Long outilid) {
        Member user = memberRepository.findById(userid).get();
        Member_Outil mbo = new Member_Outil();
        mbo.setUser(user);
        mbo.setId(new Member_Outil_Id(outilid, userid));
        memberOutilRepository.save(mbo);
    }
    @Override
    public List<OutilBean> findOutilsByUser(Long user_id) {
        List<OutilBean> outils = new ArrayList<>();
        Member user = memberRepository.findById(user_id).get();
        List<Member_Outil>
                idoutils = memberOutilRepository.findByUser(user);
        idoutils.forEach(s -> {
                    outils.add(outilProxy.findOutil(s.getId().getOutil_id()));
                }
        );
        return outils;
    }
    @Override
    public Member findMemberByOutil(Long outil_id){
//        OutilBean outil = outilProxy.findOutil(outil_id);
        Member member;
        List<Member_Outil> memberOutils = memberOutilRepository.findAll();
        for (Member_Outil m:
             memberOutils) {
            if (m.getId().getOutil_id().equals(outil_id)){
                member = m.getUser();
                return member;
            }
        }
        return null;
    }
    @Override
    public Member findMemberById(Long id){
        return memberRepository.findById(id).get();
    }
    @Override
    public void affecterMemberToEvenement(Long memberid, Long eventid) {
        Member member = memberRepository.findById(memberid).get();
        Member_Evenement mbe = new Member_Evenement();
        mbe.setMember(member);
        mbe.setEventId(eventid);
        memberEvenRepository.save(mbe);

    }
    @Override
    public List<EvenementBean> findEvenementsByMember(Long memberid) {
        List<EvenementBean> events = new ArrayList<>();
        Member member = memberRepository.findById(memberid).get();
        List<Member_Evenement> memberEvenements = memberEvenRepository.findByMember(member);
        memberEvenements.forEach
                (memberEvenement -> {
                    events.add(evenProxy.findEvenementById(memberEvenement.getEventId()));
                }
        );
        return events;
    }
    @Override
    public List<Member> findMembersByEvent(Long eventId){
        List<Member> members = new ArrayList<>();
        List<Member_Evenement> memberEvenements = memberEvenRepository.findByEventId(eventId);
        memberEvenements.forEach
                (memberEvenement -> {
                            members.add(memberEvenement.getMember());
                        }
                );
        return members;
    }
    @Override
    public List<EnseignantChercheur> getEnseignants(){
        return enseignantChercheurRepository.findAll();
    }
    @Override
    public List<Etudiant> getEtudiants(){
        return etudiantRepository.findAll();
    }
    @Override
    public void deleteMemberEvenementsByMemberId(Long memberId){
        Member member = memberRepository.findById(memberId).get();
        memberEvenRepository.deleteAllByMember(member);
    }
    @Override
    public void deleteMemberPubsByMemberId(Long memberId){
        Member member = memberRepository.findById(memberId).get();
        memberPubRepository.deleteAllByAuteur(member);
    }
    @Override
    public void deleteMemberToolsByMemberId(Long memberId){
        Member member = memberRepository.findById(memberId).get();
        memberOutilRepository.deleteAllByUser(member);
    }

    @Override
    public void setEncadrantToNull(EnseignantChercheur enseignantChercheur){
        List<Etudiant> etudiants = etudiantRepository.findEtudiantsByEncadrant(enseignantChercheur);
        for (Etudiant etudiant:  etudiants) {
            etudiant.setEncadrant(null);
        }
        etudiantRepository.saveAllAndFlush(etudiants);
    }

    @Override
    public void deleteMemberEventsByEventId(Long id){
        memberEvenRepository.deleteAllByEventId(id);
    }

    @Override
    public Map<String,Integer> getNumberMembersPerGrade(){
        List<EnseignantChercheur> enseignants = enseignantChercheurRepository.findAll();

        Map<String, Integer> numberPerGrade = new HashMap<>();
        for(EnseignantChercheur ens: enseignants) {
            if (numberPerGrade.containsKey(ens.getGrade())) {
                numberPerGrade.put(ens.getGrade(), numberPerGrade.get(ens.getGrade()) + 1);
            } else {
                numberPerGrade.put(ens.getGrade(), 1);
            }
        }

        return numberPerGrade;
    }

    @Override
    public Map<String,Integer> getNumberMembersPerDiplome(){
        List<Etudiant> etudiants = etudiantRepository.findAll();

        Map<String, Integer> numberPerDiplome = new HashMap<>();
        for(Etudiant etd: etudiants) {
            if (numberPerDiplome.containsKey(etd.getDiplome())) {
                numberPerDiplome.put(etd.getDiplome(), numberPerDiplome.get(etd.getDiplome()) + 1);
            } else {
                numberPerDiplome.put(etd.getDiplome(), 1);
            }
        }

        return numberPerDiplome;
    }

    @Override
    public Map<String,Integer> getNumberMembersPerEtablissement(){
        List<EnseignantChercheur> enseignantChercheurs = enseignantChercheurRepository.findAll();

        Map<String, Integer> numberPerEtablissement = new HashMap<>();
        for(EnseignantChercheur ens: enseignantChercheurs) {
            if (numberPerEtablissement.containsKey(ens.getEtablissement())) {
                numberPerEtablissement.put(ens.getEtablissement(), numberPerEtablissement.get(ens.getEtablissement()) + 1);
            } else {
                numberPerEtablissement.put(ens.getEtablissement(), 1);
            }
        }

        return numberPerEtablissement;
    }

}
