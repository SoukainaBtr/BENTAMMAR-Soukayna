package com.trait.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.trait.models.utilisateur;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

@CrossOrigin
public interface utilisateurRepository extends PagingAndSortingRepository<utilisateur, Long> {
	public List<utilisateur> findByNom(String nom);


}
