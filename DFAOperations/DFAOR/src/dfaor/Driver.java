/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaor;

/**
 *
 * @author asadj
 */
public class Driver {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
      
        String[] Floatinputs={"a","b"};
        int FloatInitialState=0;
        int[] FloatFinalStates={1};
        int[][] FloatMatrix={{1,0},{1,0}};
        
        
        DFA FloatAutomata=new DFA(FloatMatrix,Floatinputs, FloatInitialState, FloatFinalStates);
        
      
   
        
      //2) Float Automata
        
        String[] input={"a","b"};
        int InitialStates=0;
        int[] FinalStates={2};
        int[][] Matrix={{1,0},{1,2},{2,2}};
        
        
        DFA Automata=new DFA(Matrix,input, InitialStates, FinalStates);
        
        
        DFAOR or=new DFAOR(Automata, FloatAutomata);
        
        DFA result=or.OR();
        
        
        System.out.println(result.validate("b"));
        System.out.println(result.validate("ab"));
    }
    
}
