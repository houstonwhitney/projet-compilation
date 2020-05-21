/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nos_classes;

import java.util.List;

public class automate {
	
	private Etat etat_initial;
	private List<transition> liste_etat;
	
	public automate(Etat etat_initial, List<transition> liste_etat) {
		super();
		this.etat_initial = etat_initial;
		this.liste_etat = liste_etat;
	}

	public Etat getinitial() {
		return etat_initial;
	}

	public void setinitial(Etat etat_initial) {
		this.etat_initial = etat_initial;
	}

	public List<transition> getListe_etat() {
		return liste_etat;
	}

	public void setListe_etat(List<transition> liste_etat) {
		this.liste_etat = liste_etat;
	}
}

/**
 *
 * @author Mon PC
 */
