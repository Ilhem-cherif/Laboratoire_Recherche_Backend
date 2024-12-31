package com.member.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.member.demo.dao.MembreRepository;
import com.member.demo.entities.EnseignantChercheur;
import com.member.demo.entities.Etudiant;
import com.member.demo.entities.Membre;
import com.member.demo.services.IMemberService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/members")
public class MemberController {

	private final IMemberService memberService;

	@GetMapping("/")
	public List<Membre> findMembres (){
	return memberService.findAll();
	}
	@GetMapping(value="/{id}")
	public Membre findOneMemberById(@PathVariable Long id){
	return memberService.findMember(id);
	}
	@GetMapping(value="/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin)
	{
	return memberService.findByCin(cin);
	}
	@GetMapping(value="/search/email")
	public Membre findOneMemberByEmail(@RequestParam String email)
	{
	return memberService.findByEmail(email);
	}
	@PostMapping(value="/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m)
	{
	return memberService.addMember(m);
	}
	@PostMapping(value="/etudiant")
	public Membre addMembre(@RequestBody Etudiant e)
	{
	return memberService.addMember(e);
	}
	@DeleteMapping(value="/{id}")
	public void deleteMembre(@PathVariable Long id)
	{
		memberService.deleteMember(id);
	}
	@PutMapping(value="/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p)
	{
		p.setId(id);
		return memberService.updateMember(p);
	}
	@PutMapping(value="/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p)
	{
		p.setId(id);
		return memberService.updateMember(p);
	}
	@PostMapping("/assignStudent")
    public ResponseEntity<?> assignStudentToTeacher(@RequestParam Long studentId, @RequestParam Long teacherId) {
        memberService.affecterEtudiantToEnseignant(studentId, teacherId);
        return ResponseEntity.ok("Student assigned to teacher successfully.");
    }
    @GetMapping("/teacher/{teacherId}/students")
    public ResponseEntity<List<Etudiant>> getStudentsByTeacher(@PathVariable Long teacherId) {
        List<Etudiant> students = memberService.getEtudiantsByEnseignant(teacherId);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/fullmember/{id}")
    public Membre findAFullMember(@PathVariable(name="id") Long id)
    {

	    Membre mbr=memberService.findMember(id);
	    mbr.setPubs(memberService.findPublicationparauteur(id));
	    return mbr;
    }
	
	
	
	
}
