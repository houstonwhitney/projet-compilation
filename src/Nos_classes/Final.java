/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nos_classes;

import java.util.List;

/**
 *
 * @author Mon PC
 */
public class Final {
   private Etat etat;
   private List<Etat> liste;

    public Final(Etat etat, List<Etat> liste) {
        this.etat = etat;
        this.liste = liste;
    }

    public Etat getEtat() {
        return etat;
    }

    public List<Etat> getListe() {
        return liste;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    
    public void setListe(List<Etat> liste) {
        this.liste = liste;
    }
   
    
    public void testFinal(){
        for(Etat e: this.liste){
            if(e.isStatut())
                this.etat.setStatut(true);
        }
    }
   
    
    public boolean isThere(List<Etat> etat){
        if(etat.size()==this.liste.size()){
            for (int i=0; i<etat.size(); i++)
                if(etat.get(i).getLibelle()!=this.liste.get(i).getLibelle())
                    return false;
                    
            return true;
        }
        return false;
    }
   
   
   
   
}
