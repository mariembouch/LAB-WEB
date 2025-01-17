package tn.enis.member.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import tn.enis.member.beans.EvenementBean;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Member_Outil;
import tn.enis.member.services.IMemberService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@AllArgsConstructor
@RestController
public class MembreRestController {


    IMemberService memberService;

//    @CrossOrigin
    @GetMapping(value="/members")
    public List<Member> findMembers (){
        return memberService.findAll();
    }

//    @CrossOrigin
    @GetMapping(value="/members/{id}")
    public Member findOneMemberById(@PathVariable Long id){
        return memberService.findMember(id);
    }

//    @CrossOrigin
    @GetMapping(value="/members/search/cin")
    public Member findOneMemberByCin(@RequestParam String cin)
    {
        return memberService.findByCin(cin);
    }


//    @CrossOrigin
    @PostMapping(value="/members/enseignant/create")
    public Member addMember(@RequestBody EnseignantChercheur m)
    {
        return memberService.addMember(m);
    }


//    @CrossOrigin
    @PostMapping(value="/members/etudiant/create")
    public Member addMember(@RequestBody Etudiant e)
    {
        return memberService.addMember(e);
    }


//    @CrossOrigin
    @DeleteMapping(value="/members/enseignant/{id}/delete")
    public void deleteEnseignant(@PathVariable(name="id") Long idEnseignant)
    {
        memberService.deleteMemberEvenementsByMemberId(idEnseignant);
        memberService.deleteMemberPubsByMemberId(idEnseignant);
        memberService.deleteMemberToolsByMemberId(idEnseignant);
        Member member = memberService.findMemberById(idEnseignant);
        memberService.setEncadrantToNull((EnseignantChercheur) member);
        memberService.deleteMember(idEnseignant);
    }

    //    @CrossOrigin
    @DeleteMapping(value="/members/etudiant/{id}/delete")
    public void deleteEtudiant(@PathVariable(name="id") Long idEtudiant)
    {
        memberService.deleteMemberEvenementsByMemberId(idEtudiant);
        memberService.deleteMemberPubsByMemberId(idEtudiant);
        memberService.deleteMemberToolsByMemberId(idEtudiant);

        memberService.deleteMember(idEtudiant);
    }


//    @CrossOrigin
    @PutMapping(value="/members/etudiant/{id}/update")
    public Member updateMember(@PathVariable Long id, @RequestBody Etudiant p)
    {
        p.setId(id);
        return memberService.updateMember(p);
    }

//    @CrossOrigin
    @PutMapping(value="/members/enseignant/{id}/update")
    public Member updateMember(@PathVariable Long id, @RequestBody EnseignantChercheur p)
    {
        p.setId(id);
        return memberService.updateMember(p);
    }


//    @CrossOrigin
    @GetMapping("/fullmember/{id}")
    public Member findAFullMember(@PathVariable(name="id") Long id)
    {

        Member mbr= memberService.findMember(id);
        mbr.setPubs(memberService.findPublicationparauteur(id));
        mbr.setEvents(memberService.findEvenementsByMember(id));
        mbr.setOutils(memberService.findOutilsByUser(id));
        return mbr;
    }


//    @CrossOrigin
    @GetMapping("/fullmembers")
    public List<Member> getFullMembers()
    {
        List<Member> members = memberService.findAll();
        for ( Member member: members) {
            member.setPubs(memberService.findPublicationparauteur(member.getId()));
            member.setEvents(memberService.findEvenementsByMember(member.getId()));
            member.setOutils(memberService.findOutilsByUser(member.getId()));
        }

        return members;
    }

//    @CrossOrigin
    @GetMapping("/members/numberpublications")
    public List<Number> getPublicationsPerMembers()
    {
        List<Member> members = memberService.findAll();
        List<Number> nbPubsPerMember = new Vector<>();
        for ( Member member: members) {
            member.setPubs(memberService.findPublicationparauteur(member.getId()));
            nbPubsPerMember.add(member.getPubs().size());
        }

        return nbPubsPerMember;
    }

    @GetMapping("/members/numberoutils")
    public List<Number> getOutilsPerMembers()
    {
        List<Member> members = memberService.findAll();
        List<Number> nbOutilsPerMember = new Vector<>();
        for ( Member member: members) {
            member.setOutils(memberService.findOutilsByUser(member.getId()));
            nbOutilsPerMember.add(member.getOutils().size());
        }

        return nbOutilsPerMember;
    }


    //    @CrossOrigin
    @GetMapping("/members/members-per-role")
    public Map<String, Number> getNumberMembersPerRole()
    {
        List<EnseignantChercheur> enseignants = memberService.getEnseignants();
        List<Etudiant> etudiants = memberService.getEtudiants();
        Map<String, Number> numberPerRole = new HashMap<>();
        numberPerRole.put("enseignant", enseignants.size());
        numberPerRole.put("etudiant", etudiants.size());

        return numberPerRole;
    }

    @GetMapping("/members/members-per-grade")
    public Map<String, Integer> getNumberMembersPerGrade()
    {
        return memberService.getNumberMembersPerGrade();

    }

    @GetMapping("/members/members-per-diplome")
    public Map<String, Integer> getNumberMembersPerDiplome()
    {
        return memberService.getNumberMembersPerDiplome();

    }

    @GetMapping("/members/members-per-etablissement")
    public Map<String, Integer> getNumberMembersPerEtablissement()
    {
        return memberService.getNumberMembersPerEtablissement();

    }
    @PutMapping("/members/affect-encadrant/{idEnseignant}")
    public void affectEtudiantToEncadrant(@RequestBody Long idMember,
                                          @PathVariable(name="idEnseignant") Long idEnseignant){
        memberService.affectEtudiantToEncadrant(idMember,idEnseignant);
    }
//    @CrossOrigin
    @PostMapping("/members/affect-event/{idEvent}")
    public void affectMemberToEvent(@RequestBody Long idMember,
                                         @PathVariable(name="idEvent") Long idEvent)
    {
        memberService.affecterMemberToEvenement(idMember, idEvent);
    }

//    @CrossOrigin
    @PostMapping("/members/affect-tool/{idTool}")
    public void affectMemberToTool(@RequestBody Long idMember,
                                    @PathVariable(name="idTool") Long idTool)
    {
        memberService.affecterUserToOutil(idMember, idTool);
    }

//    @CrossOrigin
    @PostMapping("/members/affect-pub/{idPub}")
    public void affectMemberToPub(@RequestBody Long idMember,
                                    @PathVariable(name="idPub") Long idPub)
    {
        memberService.affecterauteurTopublication(idMember, idPub);
    }

//    @CrossOrigin
    @GetMapping("/members/enseignants")
    public List<EnseignantChercheur> getEnseignants(){
        return memberService.getEnseignants();
    }

//    @CrossOrigin
    @GetMapping("/members/etudiants")
    public List<Etudiant> getEtudiants(){
        return memberService.getEtudiants();
    }

    @GetMapping("/members/members-outil/{idOutil}")
    public Member getMemberByOutil(@PathVariable(name="idOutil") Long idOutil){
        return memberService.findMemberByOutil(idOutil);
    }

    @GetMapping("/members-per-event/{idEvent}")
    public List<Member> getMemberByEvent(@PathVariable (name="idEvent") Long idEvent){
        return memberService.findMembersByEvent(idEvent);
    }

    @DeleteMapping("/members-per-event/{idEvent}/delete")
    public void deleteMemberEventsByEvent(@PathVariable (name="idEvent") Long idEvent){
        memberService.deleteMemberEventsByEventId(idEvent);
    }



}
