
package Interfaces;

import Nos_classes.Etat;
import Nos_classes.Final;
import Nos_classes.automate;
import Nos_classes.stockage;
import Nos_classes.transition;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class implementation_function implements prototypes_fonctions {

    public implementation_function() {
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
    }
    @Override
    public List alph(String mot){
        ArrayList list=new ArrayList();
        for(int i=0; i< mot.length(); i++){
            list.add(mot.charAt(i));
        }
        return list;
    }
    
    public boolean estDanslAlphabet(String mot){
        for(int i=0; i<mot.length(); i++){
            int p=0;
            char m=mot.charAt(i);
            if(!isOperator(m)){
            for(int j=0; j<this.getAlphabet().size(); j++){
                if(m==(char) this.getAlphabet().get(j))
                    p=1;
            }
            if(p==0)
                return false;
            }
        }
        return true;
    }
    
    //function de verification si un mot appartient a un langage
    
    @Override
   
    public boolean verification_alphabet(String mot) {
         int cpt=0;
         int i = 0;
         char m=mot.charAt(i);
         
         
         
         return true;
    }

    // verifie si un mot est un operateur ou juste un symbole
    @Override
    public boolean isOperator(char mot) {
        if(mot=='|' || mot=='*' || mot=='.' || mot=='(' || mot==')')
            return true;
        
        return false;
    }

    
    // teste si un caractere appartient a une liste de carateres
    @Override
    public boolean isInto(char a, List<stockage> stock) {
        for(stockage s: stock)
            if(s.getValeur()==a)
                return true;
            
        return false;
    }

    
    //etablir une priorite entre les operateurs
    @Override
    public int priority(char mot){
        if(mot=='.')
            return 2;
        if(mot=='|')
            return 1;
        return 3;
        
    }

    
    
    
    //Nos fonctions elementaires: concatenation
    @Override
    public automate concatenation(automate a1, automate a2) {
        List<transition> list=a1.getListe_etat();
        automate a=null;
        for(int i=0; i<list.size(); i++){
            transition t=list.get(i);
            if(t.getDestination().isStatut()){
                t.getDestination().setStatut(false);
                transition t1=new transition('£', t.getDestination(), a2.getinitial());
                List<transition> l=a1.getListe_etat();
                l.add(t1);
                l.addAll(a2.getListe_etat());
                a=new automate(a1.getinitial(), l);
                return a;
                
            }
        }
       return null;
    }

    
    
    
    // function union
    @Override
    public automate union(automate a1, automate a2) {
        Etat depart=new Etat(etat, false);
        etat++;
        Etat dest=new Etat(etat, true);
        etat++;
        transition t1=new transition('£', depart, a1.getinitial());
        transition t2=new transition('£', depart, a2.getinitial());
        transition t3=null;
        transition t4=null;
        for(int i=0; i<a1.getListe_etat().size(); i++){
            transition t=a1.getListe_etat().get(i);
            if(t.getDestination().isStatut()){
                t.getDestination().setStatut(false);
                t3=new transition('£', t.getDestination(), dest);
            }
        }
        
        for(int i=0; i<a2.getListe_etat().size(); i++){
            transition t=a2.getListe_etat().get(i);
            if(t.getDestination().isStatut()){
                t.getDestination().setStatut(false);
                t4=new transition('£', t.getDestination(), dest);
            }
        }
        
        List<transition> liste=new ArrayList<transition>();
        liste.add(t1);
        liste.add(t2);
        liste.addAll(a1.getListe_etat());
        liste.addAll(a2.getListe_etat());
        liste.add(t3);
        liste.add(t4);
        
        return new automate(depart, liste);
    }

    
    
    //function etoile***
    @Override
    public automate multiplicite(automate a) {
        Etat depart=new Etat(etat, false);
        etat++;
        Etat dest=new Etat(etat, true);
        etat++;
        
        transition t1=new transition('£', depart, a.getinitial());
        transition t2=null;
        transition t3=null;
        transition t4=new transition('£', depart, dest);
        for(int i=0; i<a.getListe_etat().size(); i++){
            transition t=a.getListe_etat().get(i);
            if(t.getDestination().isStatut()){
                t2=new transition('£', t.getDestination(), dest);
            }
        }
        for(int i=0; i<a.getListe_etat().size(); i++){
            transition t=a.getListe_etat().get(i);
            if(t.getDestination().isStatut()){
                t.getDestination().setStatut(false);
                t3=new transition('£', t.getDestination(), a.getinitial());
            }
        }
        
        List<transition> liste=new ArrayList<transition>();
        liste.add(t1);
        liste.addAll(a.getListe_etat());
        liste.add(t2);
        liste.add(t3);
        liste.add(t4);
        
        return new automate(depart, liste);
        
        
    }

    
    
    //construction de l'automate elementaire
    @Override
    public automate elementaire(char mot) {
        Etat depart=new Etat(etat, false);
        etat++;
        Etat arriver=new Etat(etat, true);
//        System.out.println(arriver.getLibelle()+" "+arriver.isStatut());
        etat++;
        transition t=new transition(mot, depart, arriver);
        List l=new ArrayList<transition>();
        l.add(t);
        automate a=new automate(depart, l);
        return a;
    }
    
    
    
    // function de l'affichage d'un automate
    @Override
    public void afficherAutomate(automate a){
        for(transition t: a.getListe_etat())
        {
            System.out.println(t.getDepart().getLibelle()+"--"+t.getSymbole()+"-->"+t.getDestination().getLibelle());
        }
    }
    
    

    
    // sous forme posfixer
    @Override
    public List<stockage> postFixer(String value) {
     List<stockage> liste=new ArrayList<stockage>();
        Stack symbole=new Stack();
        Stack operateur=new Stack();
        
        for(int i=0; i<value.length(); i++){
            char c=value.charAt(i);
            if(!isOperator(c)){
                symbole.add(c);
            }else{
                if(operateur.isEmpty()){
                    operateur.add(c);
                }else{
                if(c=='('){
                    operateur.add(c);
                }else{
                    if(c==')'){
                        while((char)operateur.peek()!='(')
                            symbole.add(operateur.pop());
                        operateur.pop();
                    }else{
                        if((char) operateur.peek()=='('){
                            operateur.add(c);
                        }else{
                            if(priority(c)>priority( (char) operateur.peek())){
                                operateur.add(c);
                            }else{
                                while(!operateur.isEmpty() && (char) operateur.peek()!='(' && priority(c)<=priority( (char) operateur.peek())){
                                    symbole.add(operateur.pop());
                                }
                                 operateur.add(c);
                            }
                        }
                    }
                }
                
                
                
            }
            
        } 
        }
        
        for(int i=operateur.size()-1; i>=0; i--){
            symbole.add(operateur.get(i));
        }
        
        
        
        for(int i=0; i<symbole.size(); i++){
            int e=1;
            if(isOperator((char) symbole.get(i))){
                e=0;
            }
            
            
            stockage s=new stockage((char) symbole.get(i), e);
            liste.add(s);
        }
            
        
        
        return liste;
    }

    
    //suppression de doublons
    public String suppDoublons(String m){
        String mot=""+m.charAt(0);;
        for(int i=1; i<m.length(); i++){
            if(!mot.contains(""+m.charAt(i)))
                mot+=m.charAt(i);
        }
        return mot;
    }
    
    
    
    
    
    public String infiXer(String val)  {
        String mot="";
        int l=val.length()-1;
        for(int i=0; i<=l; i++){
            char c=val.charAt(i);
            mot+=c;
            if(i<l){
                if(!isOperator(c)){
                    if(!isOperator(val.charAt(i+1)))
                        mot+='.';
                    if(val.charAt(i+1)=='(')
                        mot+='.';
                }else{
                    if(c=='*' || c==')'){
                        if(val.charAt(i+1)=='(')
                            mot+='.';
                        
                        if(!isOperator(val.charAt(i+1)))
                            mot+='.';
                    }
                    
                }
            }
        }    
        return mot;
    }
        
    public boolean isOperator1(char c){
        
    return c=='|'|| c=='*';
    }
        
    public boolean Ver_infixer(String mot) {
		Stack<Character> pile=new Stack<Character>();
                int l=mot.length()-1;
		for(int i = 0; i < mot.length(); i++) {
			
			if(isOperator1(mot.charAt(i))){
				if(i<l && mot.charAt(i)==mot.charAt(i+1)){
					System.out.println("operateur doubler");
					return false;
				}
				if(i<l && (mot.charAt(i)=='|')&&(mot.charAt(i+1)=='*')){
					System.out.println("Faux");
					return false;
				}
					
			}
				
				
			if(mot.charAt(i) == '(') {
				pile.push(mot.charAt(i));
				if(i<l && mot.charAt(i+1)==')'){
					System.out.println("Erreur ");
					return false;
				}
				if(i<l && mot.charAt(i)=='|' && mot.charAt(i+1)==')'){
					System.out.println("Errer 1");
					return false;
				}
				
			}
			else if(mot.charAt(i) ==')' && i <=l) {
				
				if(pile.isEmpty()) {
					System.out.println("votre expression contient plus de parenthese fermente que de ouvrante");
					return false;
				}
				else {
					pile.pop();
				}
			}
		}
		if(pile.isEmpty())
			return true;
		else
			System.out.println("votre expression contient plus de parenthese ouvrante que de fermente");
			return false;
	}
    
    
    
         
        
        
        
    
    // function de text du posfixer
    public void test(List<stockage> l){
        String mot="";
        for(stockage s : l){
            mot=mot+s.getValeur();
        }
        System.out.println("postfixer=  "+mot);
    }
    
      public void test1(List<Etat> l){
        String mot="";
        for(Etat s : l){
            System.out.println("Etat: "+s.getLibelle());
        }
    }
    
    
    
    

    
    //construction d'un automate
    @Override
    public automate construction(List<stockage> liste) {
        Stack<automate> pile=new Stack<automate>();
        for(stockage s:liste){
            if(s.getIsOperateur()==1){
                pile.add(this.elementaire(s.getValeur()));
            }else{
                if(s.getValeur()=='*')
                    pile.add(this.multiplicite(pile.pop()));
                if(s.getValeur()=='|'){
                    automate a=pile.pop();
                    pile.add(this.union(pile.pop(), a));
                }
                if(s.getValeur()=='.'){
                    automate a=pile.pop();
                    pile.add(this.concatenation(pile.pop(), a));
                }
                
            }
            
        }
        
        return pile.pop();
    }

    
    
    //function £-fermeture
    @Override
    public List<Etat> e_fermeture(List<Etat> list,automate a) {
        List<Etat> li=new ArrayList<Etat>();
        li.addAll(list);
        Stack<Etat> pile=new Stack<Etat>();
        pile.addAll(list);
        
        while(!pile.isEmpty()){
            Etat t=pile.pop();
            List<transition> liste=this.getlisteEtat(t, a.getListe_etat());
            for(transition tr : liste){
                if(tr.getSymbole()=='£'){
                    if(!into(li, tr.getDestination())){
                        li.add(tr.getDestination());
                        pile.add(tr.getDestination());
                    }
                }       
                    
            }
        }
        return li;
    }
    
    //function de construction d'un automte
    @Override
    public List<Etat> transiter(List<Etat> list, char car, automate a) {
        List<Etat> li=new ArrayList<Etat>();
        Stack<Etat> pile=new Stack<Etat>();
        for(Etat e: list)
            pile.add(e);
        
        
        while(!pile.isEmpty()){
            Etat e=pile.pop();
            if(transiter(e, car, a)!=null){
                Etat t=transiter(e, car, a);
                if(!into(li, t)){
                        li.add(t);
                        pile.add(t);
                }
            }

        }
        
        return li;
    }

    
    
    // verification si un etat final est contenu dans une liste d'etat et rend la liste finale
    @Override
    public Etat into(List<Final> list, List<Etat> etat) {
        for(Final l: list)
            if(l.isThere(etat))
                return l.getEtat();
        return null;
    }

    
    
    
    // verification si un etat existe deja dans une liste d'etat
    @Override
    public boolean into(List<Etat> list, Etat etat) {
        for(Etat e: list){
            if(e.getLibelle()==etat.getLibelle())
                return true;
        }
        return false;
    }

    
    
    
    
    // function de determinisation de l'automate
    @Override
    public automate automate_Det(automate a) {
        Etat e=new Etat(this.det, false);
        this.det++;
        List<Etat> l=new ArrayList<Etat>();
        List<transition> trans=new ArrayList<transition>();
        l.add(a.getinitial());
        List<Etat> list=this.e_fermeture(l, a);
        
        List<Final> fin=new ArrayList<Final>();
        Final etatInit=new Final(e,list);
        etatInit.testFinal();
        Stack<Final> pile=new Stack<Final>();
        pile.add(etatInit);
        fin.add(etatInit);
        List alpha=this.getAlphabet();
        while(!pile.isEmpty()){
            Final etat=pile.pop();
            for(int i=0; i<alpha.size(); i++){
                char mot=(char) alpha.get(i);
                list=this.e_fermeture(this.transiter(etat.getListe(), mot, a), a);
                if(list.size()!=0){
                if(into(fin, list)!=null){
                    transition t=new transition(mot, etat.getEtat(), into(fin, list)); 
                    trans.add(t);
                }else{
                    Etat ee=new Etat(this.det, false);
                    transition t=new transition(mot, etat.getEtat(), ee);
                    trans.add(t);
                    this.det++;
                    Final f=new Final(ee, list);
                    pile.add(f);
                    fin.add(f);
                }
                }
            }
        }
        
        for(Final f: fin){
            f.testFinal();
        }
   
//        automate aa=new automate(etatInit.getEtat(), trans);
//        for(transition t: aa.getListe_etat()){
//                System.out.println("etat depart: "+t.getDepart().getLibelle()+"  status: "+t.getDepart().isStatut());
//                System.out.println("etat arrive: "+t.getDestination().getLibelle()+"  status: "+t.getDestination().isStatut());
//            }
        return new automate(etatInit.getEtat(), trans);
    }

    
    
    
    // function transiter
    @Override
    public Etat transiter(Etat etat, char a,automate a1) {
            List<transition> liste=this.getlisteEtat(etat, a1.getListe_etat());
            for(transition tr : liste){
                if(tr.getSymbole()==a){
                    return tr.getDestination();
                }   
            }
        return null;
    }
        

    
    
    
    
    // function d'evaluatio de l'automate
    @Override
    public boolean evaluer(automate a, String mot) {
        Etat e=a.getinitial();
        for(int i=0; i<mot.length(); i++){
            char m=mot.charAt(i);
            if(transiter(e, m, a)==null){
                return false;
            }
            e=transiter(e, m, a);
        }
        return e.isStatut();
    }

    
    // function de recuperation de l'alphabet
    public List getAlphabet() {
        return alphabet;
    }

    
    
    
    // function de recuperation du langage
    public String getLangage() {
        return langage;
    }

    
    
    // functionde modificaion de l'alphabet
    public void setAlphabet(List alphabet) {
        this.alphabet = alphabet;
    }

    
    
    
    // function de modification du langage
    public void setLangage(String langage) {
        this.langage = langage;
    }
    
    
    
    
    // function de stockage de l'alphabet
    public List StockAlphabet(String mot){
        List m=new ArrayList();
        for(int i=0; i<mot.length(); i++){
            m.add(mot.charAt(i));
            mot=mot.replaceAll(mot.charAt(i)+"","").trim();
        }
        return m;
    }
    
    @Override
    public List<transition> getlisteEtat(Etat e,List<transition> l){
        List<transition> liste=new ArrayList<transition>();
        for(transition t: l){
            if(t.getDepart().getLibelle()==e.getLibelle())
                liste.add(t);
        }
        return liste;
    }
   
    
    
    
    
    
    
    
    
    // queques declarations des variables utilisees
    private List alphabet=new ArrayList();
    private String langage;
    private static int etat=0;
    private static int det=0;
}
