package com.trait.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trait.models.utilisateur;
import com.trait.services.UtilisateurService;
import com.trait.services.UtilisateurServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("/utilisateurs")
public class utilisateurController {


    @Autowired
    private UtilisateurServiceImpl  utilisateurService;
     
    @RequestMapping("/test")
	public @ResponseBody String greeting() {
		return utilisateurService.wereIn();
	} 
    @GetMapping
    public ResponseEntity<List<utilisateur>> getAllutilisateurs(@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) 
    {
	
        List<utilisateur> list = utilisateurService.getAllUtilisateurs(pageNo, pageSize, sortBy);

    	
		return new ResponseEntity<List<utilisateur>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<utilisateur> save(@RequestBody utilisateur user)
    {
    	utilisateur u = utilisateurService.save(user);
        System.out.println(user.getNom() +"  ---  "+user.getEmail());
        return new ResponseEntity<utilisateur>(u, HttpStatus.CREATED);
    }
    
}
