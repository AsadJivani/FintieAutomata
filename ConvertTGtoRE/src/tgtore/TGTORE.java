/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

import java.util.ArrayList;

/**
 *
 * @author asadj
 */
public class TGTORE {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       
          ArrayList<ArrayList<Object[]>> TT=new ArrayList<>();
         
       
         //3 rows in Transition table
         
         ArrayList<Object[]>  State0=new ArrayList<>();
         ArrayList<Object[]>  State1=new ArrayList<>();       
         ArrayList<Object[]>  State2=new ArrayList<>();       
         ArrayList<Object[]>  State3=new ArrayList<>();       
         
         ArrayList<Object[]>  Initital=new ArrayList<>();
         ArrayList<Object[]>  Final=new ArrayList<>();
         
         
         
         //each row has multiplle arrays
         
         State0.add(new Object[]{0,"a"});
         State0.add(new Object[]{1,"b"});
         
         
         State1.add(new Object[]{0,"a"});
         State1.add(new Object[]{1,"b"});
         State1.add(new Object[]{3,""});
         
       
         
         Initital.add(new Object[]{0,""});
         
         
         TT.add(State0);
         TT.add(State1);
     
         
         TT.add(Initital);
         TT.add(Final);
         
         
         TG re=new TG(TT);
         
        System.out.println(re.TGTORE())   ;
 
         
               
         
        
        
        
        
    }
}
