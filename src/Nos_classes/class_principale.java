/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nos_classes;


import Fenetre_accueil.fen;
import Interfaces.implementation_function;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mon PC
 */
public class class_principale {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new fen().setVisible(true);
        

        // TODO code application logic here
        implementation_function imp=new implementation_function();
        automate a=imp.elementaire('a');
//        automate a1=imp.elementaire('b');
//        automate a2=imp.elementaire('c');
//        a1=imp.concatenation(a, a1);
//        a1=imp.concatenation(a1, a2);
//        a1=imp.automate_Det(a1);
//        imp.afficherAutomate(a);
//imp.afficherAutomate(imp.multiplicite(a));


//System.out.println(" infixer:  "+imp.infiXer("a(a|b)*cb*"));
//imp.test(imp.postFixer(imp.infiXer("a(a|b)*cb*")));
//            automate aa=imp.automate_Det(imp.construction(imp.postFixer(imp.infiXer("a(a|b)*cb*"))));
//            if(imp.evaluer(imp.automate_Det(imp.construction(imp.postFixer(imp.infiXer("a(a|b)*cb*")))), "abbbbcbbb"))
//                imp.afficherAutomate(aa);
            
            
            System.out.println(" infixer:  "+imp.infiXer("a*(bbb|c)"));
imp.test(imp.postFixer(imp.infiXer("a*(bbb|c)")));
            automate aa=imp.automate_Det(imp.construction(imp.postFixer(imp.infiXer("a*(bbb|c)"))));
            if(imp.evaluer(imp.automate_Det(imp.construction(imp.postFixer(imp.infiXer("a*(bbb|c)")))), "aaaaaaaaaaac"))
                imp.afficherAutomate(aa);
            
//            for(transition t: aa.getListe_etat()){
//                System.out.println("etat depart: "+t.getDepart().getLibelle()+"  status: "+t.getDepart().isStatut());
//                System.out.println("etat arrive: "+t.getDestination().getLibelle()+"  status: "+t.getDestination().isStatut());
//            }
            
//            System.out.println("verification:"+imp.Ver_infixer("aa(a|b*|c)c|(d(a*b)((c*b))"));
//            System.out.println("infixer de aa(a|b*|c)|d(a*b)(c*b) = "+imp.infiXer("aa(a|b*|c)c|d(a*b)((c*b)"));
            
//        System.out.println("test de suppression: "+imp.suppDoublons("aaaaabbbbbbddddd"));
    }
    
}
