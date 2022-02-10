package com.trait.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.trait.models.utilisateur;
import com.trait.repositories.utilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	private utilisateurRepository userrepo;
	
	@Override
	public utilisateur save(utilisateur object) {
		return userrepo.save(object); 
	}

	@Override
	public Boolean delete(utilisateur object) {
		userrepo.delete(object); 
		return true;
	}
 

	@Override
	public   utilisateur  findByNom(String nom) { 
		return userrepo.findByNom(nom).get(0);
	}

	@Override
	public List<utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<utilisateur> getAllUtilisateurs(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 
        Page<utilisateur> pagedResult = userrepo.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();   
        } else {
            return new ArrayList<utilisateur>();
        } 
	}
 
	public String wereIn() {
		return "Hello, World";
	}

}
