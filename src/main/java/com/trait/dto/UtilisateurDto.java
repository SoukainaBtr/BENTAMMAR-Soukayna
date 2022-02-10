package com.trait.dto;

import java.io.Serializable;
 

import com.trait.models.utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto implements Serializable {
	

    private static final long serialVersionUID = 1L;

    private utilisateur utilisateur;
    private long count;
}
