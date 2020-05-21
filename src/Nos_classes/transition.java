/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nos_classes;


public class transition {

		private char symbole;
		private Etat depart;
                private Etat destination;
                
                    public transition(char symbole, Etat depart, Etat destination) {
                        this.symbole = symbole;
                        this.depart = depart;
                        this.destination = destination;
                    }
                
                
		public void setSymbole(char symbole) {
			this.symbole = symbole;
		}
               
                public void setDestination(Etat destination) {
                    this.destination = destination;
		}
                
                public void setDepart(Etat depart) {
                    this.depart = depart;
                }
                
		public char getSymbole() {
                    return symbole;
		}
                
		public Etat getDestination() {
                    return destination;
		}
		
                

                public Etat getDepart() {
                    return depart;
                }

    


		
		
        
        
		
}


/**
 *
 * @author Mon PC
 */

    
