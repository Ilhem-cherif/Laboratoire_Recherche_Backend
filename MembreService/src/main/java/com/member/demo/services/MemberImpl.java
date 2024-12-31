package com.member.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.member.demo.beans.PublicationBean;
import com.member.demo.dao.EnseignantChercheurRepository;
import com.member.demo.dao.EtudiantRepository;
import com.member.demo.dao.MembrePubRepository;
import com.member.demo.dao.MembreRepository;
import com.member.demo.entities.EnseignantChercheur;
import com.member.demo.entities.Etudiant;
import com.member.demo.entities.Membre;
import com.member.demo.entities.Membre_Pub_Id;
import com.member.demo.entities.Membre_Publication;
import com.member.demo.proxies.PublicationServiceProxy;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberImpl implements IMemberService {
	
	private final MembreRepository memberRepository;
	private final EtudiantRepository etudiantRepository;
	private final EnseignantChercheurRepository enseignantChercheurRepository;
	private final MembrePubRepository membrepubrepository;
	private final PublicationServiceProxy proxy;
	@Override
	public Membre addMember(Membre m) {
		return memberRepository.save(m);
	}

	@Override
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	@Override
	public Membre updateMember(Membre p) {
		return memberRepository.saveAndFlush(p);
	}

	@Override
	public Membre findMember(Long id) {
		Membre m = (Membre)memberRepository.findById(id).get();
		return m;
	}

	@Override
	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {
		return memberRepository.findByNom(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}
	@Override
    public void affecterEtudiantToEnseignant(Long studentId, Long teacherId) {
        Etudiant etudiant = etudiantRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
        EnseignantChercheur enseignant = enseignantChercheurRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + teacherId));
        etudiant.setEncadrant(enseignant);
        etudiantRepository.save(etudiant);
    }
	@Override
    public List<Etudiant> getEtudiantsByEnseignant(Long teacherId) {
        EnseignantChercheur enseignant = enseignantChercheurRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + teacherId));
        return etudiantRepository.findByEncadrant(enseignant);
    }
	@Override
	public void affecterauteurTopublication(Long idauteur, Long idpub)
	{
		Membre mbr= memberRepository.findById(idauteur).get();
		Membre_Publication mbs= new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Id(idpub, idauteur));
		membrepubrepository.save(mbs);
	}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
			List<PublicationBean> pubs=new ArrayList<PublicationBean>();
			List< Membre_Publication>
			idpubs=membrepubrepository.findpubId(idauteur);
			idpubs.forEach(s->{
				System.out.println(s);
				pubs.add(proxy.findPublicationById(s.getId().getPublication_id()));
			});
			return pubs;
		}
}
