
package Interfaces;



import Nos_classes.Etat;
import Nos_classes.Final;
import Nos_classes.automate;
import Nos_classes.stockage;
import Nos_classes.transition;
import java.util.List;


public interface prototypes_fonctions{
    
    
	//fonctions de verification de nos chaines de caracteres. 
        
        public List alph(String mot);
    
	public boolean verification_alphabet(String mot);
        public boolean Ver_infixer(String mot);
        public boolean isOperator (char mot);
        public boolean isOperator1(char c);
        public boolean isInto(char a, List<stockage> stock);
        public int priority(char mot);
        
         //AFN elementaires
        public automate concatenation (automate a1,automate a2);
	
	public automate union(automate a1,automate a2);
	
	public automate multiplicite(automate a);
	
        public automate elementaire(char mot);
        
        public void afficherAutomate(automate a);
	
	//mise sous forme postfixée et infixée bien formée
	
	public List<stockage> postFixer(String value);
//        public String infiXer(String val);
	
	//fonction de construction de l'automate
	public automate construction(List<stockage> liste);
        
        //fonction necesaire pour la determinisation
        
        public List<Etat> e_fermeture(List<Etat> list,automate a);
        
        public List<Etat> transiter(List<Etat> list, char car, automate a1);
        
        public Etat into(List<Final> list, List<Etat> etat);
        
        public boolean into(List<Etat> list, Etat etat);
        
        public automate automate_Det(automate a);
        
        // gestion de l'evaluation du mot sur l'automate
        
        public Etat transiter(Etat etat, char a,automate a1);
        
        public boolean evaluer(automate a, String mot);
       
        public List<transition> getlisteEtat(Etat e,List<transition> l);
	
	
	//differentes fonctions pour la suite
	
}

