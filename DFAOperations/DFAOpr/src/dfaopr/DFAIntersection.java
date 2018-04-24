/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaopr;

import java.util.ArrayList;

/**
 *
 * @author asadj
 */
 class DFAIntersection {
 
    DFA F1;
    DFA F2;
    
     public DFAIntersection(DFA F1,DFA F2){
 
        this.F1=F1;
        this.F2=F2;
        
       
    }
    
     public DFA Intersection(){
         
     return new DFAComplement(new DFAOR(new DFAComplement(F1).Complement(), new DFAComplement(F2).Complement()).OR()).Complement();
     
     }
    
    
    
}
