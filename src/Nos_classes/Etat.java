
package Nos_classes;


public class Etat {
    private int libelle;
    private boolean statut;

    public Etat(int libelle, boolean statut) {
        this.libelle = libelle;
        this.statut = statut;
    }

    
    
    
    public boolean isStatut() {
        return statut;
    }

    public int getLibelle() {
        return libelle;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public void setLibelle(int libelle) {
        this.libelle = libelle;
    }
 
    
       
}
