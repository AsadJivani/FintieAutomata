/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaopr;

/**
 *
 * @author asadj
 */



public class DFAOpr {
 
    
    /**
     * @param args the command line arguments
     */
    
 public static void main(String[] args) {
    
     
     
       
        String[] inputs1={"a","b"};
        int InitialState1=0;
        int[] FinalStates1={1};
        int[][] Matrix1={{1,0},{1,0}};
        
        
        DFA F1=new DFA(Matrix1,inputs1, InitialState1, FinalStates1);
        
      
   
        
      
        
        String[] input2={"a","b"};
        int InitialStates2=0;
        int[] FinalStates2={2};
        int[][] Matrix2={{1,0},{1,2},{2,2}/*{1,3},{2,3},{2,2},{1,2}*/};
        
        
        DFA F2=new DFA(Matrix2,input2, InitialStates2, FinalStates2);
        
        
        DFAOR dfaOr=new DFAOR(F1, F2);
        DFAConcat dfaAnd=new DFAConcat(F1, F2);
        DFAClosure dfaClosure=new DFAClosure(F2);
        DFAComplement dfaComplement=new DFAComplement(F2);
        DFAIntersection dfaIntersection=new DFAIntersection(F1, F2);
        
        DFA result1=dfaOr.OR();
        DFA result2=dfaAnd.AND();
        DFA result3=dfaClosure.Closure();
        DFA result4=dfaComplement.Complement();
        DFA result5=dfaIntersection.Intersection();
        
        
        System.out.println(result3.validate(""));
        
    
        
        
        
    }
  

}
