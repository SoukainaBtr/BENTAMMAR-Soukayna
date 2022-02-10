package com.trait.services;

import com.trait.helpers.IBasicCrudFunction;
import com.trait.models.utilisateur;
import java.util.List;

public interface UtilisateurService extends IBasicCrudFunction<utilisateur>  { 
	public   utilisateur  findByNom(String name);
	public List<utilisateur> getAllUtilisateurs(Integer pageNo, Integer pageSize, String sortBy);
}
