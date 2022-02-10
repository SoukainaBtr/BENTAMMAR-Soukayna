package com.trait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trait.controllers.utilisateurController;
import com.trait.models.utilisateur;
import com.trait.services.UtilisateurServiceImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
 
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
@SpringBootTest
class TpCigma1ApplicationTests {

	 
	@Autowired
	private MockMvc mockMvc;

	@Autowired
    private UtilisateurServiceImpl  utilisateurService;
     
	@Autowired
	private utilisateurController controller;
	
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	
	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		when(utilisateurService.wereIn()).thenReturn("Hello, Mock");
		this.mockMvc.perform(get("/utilisateurs/test")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, Mock")));
	}
	@Test
	public void whenValidName_thenUserShouldBeFound() {
	    String name = "anouar";
	    utilisateur found = utilisateurService.findByNom(name);
	 
	     assertThat(found.getNom()).isEqualTo(name);
	 }
//	@Test
//    public void testListeUsers() throws Exception { 
//		final String nom = "534*******";
//		final String email="a.anouar.saki@gmail.com";
//		utilisateur utilisateur = new utilisateur();
//		utilisateur.setNom(nom);
//		utilisateur.setEmail(email);
//		utilisateurService.save(utilisateur);
//	}
}
