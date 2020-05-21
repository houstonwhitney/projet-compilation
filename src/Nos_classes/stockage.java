/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nos_classes;

/**
 *
 * @author Mon PC
 */
public class stockage {

    public stockage(char valeur, int isOperateur) {
        this.valeur = valeur;
        this.isOperateur = isOperateur;
    }

    public int getIsOperateur() {
        return isOperateur;
    }

    public void setIsOperateur(int isOperateur) {
        this.isOperateur = isOperateur;
    }

    public char getValeur() {
        return valeur;
    }

    public void setValeur(char valeur) {
        this.valeur = valeur;
    }
    
    
    
    char valeur;
    int isOperateur;
}
    

