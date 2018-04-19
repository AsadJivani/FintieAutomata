/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author asadj
 */
public class NFADriverClass {
    
     public static void main(String[] args) {
     
         ArrayList<ArrayList<Object[]>> TT=new ArrayList<>();
         
       
         //3 rows in Transition table
         
         ArrayList<Object[]> State0=new ArrayList<>();
         ArrayList<Object[]> State1=new ArrayList<>();
        ArrayList<Object[]>  State2=new ArrayList<>();
        
         
         
         
         //each row has multiplle arrays
         
         
         
         Object[] tr1={0,"[a]"};
         Object[] tr2={1,"[a]"};
         Object[] tr3={2,"[a]"};
         Object[] tr4={1,"[b]"};
         Object[] tr5={2,"[b]"};
         
         
         State0.add(tr1);
         State0.add(tr2);
         State0.add(tr3);
         
         State1.add(tr2);
         State1.add(tr5);
    
         
         State2.add(tr3);
         State2.add(tr4);
         
         
         
         TT.add(State0);
         TT.add(State1);
         TT.add(State2);
      
         
         int[] finalstates={2};
         
         NFA nfa=new NFA(TT,0, finalstates);
      
         
               
               System.out.println( nfa.validate("aaaa")); 
     
     }
     
     
    
    
}
