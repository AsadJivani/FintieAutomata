/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment;

import java.util.Scanner;


/**
 *
 * @author asadj
 */
public class DFADriverClass {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
  
       
       
      
    //1) Identifier Automata   
       
        String[] Identifierinputs={"[A-Za-z]","[0-9]","[_]"};
        int IdentifierInitialState=0;
        int[] IdentifierFinalStates={2};
        int[][] IdentifierMatrix={{2,3,1},{2,2,1},{2,2,2},{3,3,3}};
        
        
        DFA IdentifierAutomata=new DFA(IdentifierMatrix,Identifierinputs, IdentifierInitialState, IdentifierFinalStates);
      
   
        
      //2) Float Automata
        
        String[] Floatinputs={"[+-]","[.]","[0-9]","[eE]"};
        int FloatInitialState=0;
        int[] FloatFinalStates={3,7};
        int[][] FloatMatrix={{1,2,1,6},{6,2,1,6},{6,6,3,6},{6,6,3,4},{5,6,7,6},{6,6,7,6},{6,6,6,6},{6,6,7,6}};
        
        
        DFA FloatAutomata=new DFA(FloatMatrix,Floatinputs, FloatInitialState, FloatFinalStates);
        
        
        //3) Char Automata
        
        String[] Charinputs={"\\\\","[rbnto]","[^']","[']"};
        int CharInitialState=0;
        int[] CharFinalStates={3};
        int[][] CharMatrix={{5,5,5,1},{4,2,2,5},{5,5,5,3},{5,5,5,5},{5,2,5,5},{5,5,5,5}};
        
        
        DFA CharAutomata=new DFA(CharMatrix,Charinputs, CharInitialState, CharFinalStates);
        
        
        //4) String Automata
        
        String[] Stringinputs={"[^\\\\\"rbtno]","[rbtno]","[\\\\]","[\"]"};
        int StringInitialState=0;
        int[] StringFinalStates={4};
        int[][] StringMatrix={{5,5,5,1},{3,3,2,4},{5,3,3,3},{3,3,2,4},{5,5,5,5},{5,5,5,5}};
        
        
        DFA StringAutomata=new DFA(StringMatrix,Stringinputs, StringInitialState, StringFinalStates);
        
        
        //5) Integer Automata
        
        String[] Integerinputs={"[+-]","[0-9]"};
        int IntegerInitialState=0;
        int[] IntegerFinalStates={2};
        int[][] IntegerMatrix={{1,2},{3,2},{3,2},{3,3}};
        
        
        DFA IntegerAutomata=new DFA(IntegerMatrix,Integerinputs, IntegerInitialState, IntegerFinalStates);
        
       
       
        Scanner input=new Scanner(System.in);
        
        
          String check = null;
          
          

        do {

            String query = input.next();
            System.out.println("GIVEN INPUT IS,");
            boolean found=false;
            
            
            if (IdentifierAutomata.validate(query)) {
                System.out.println("IDENTIFIER");
                found=true;
            }
            if (CharAutomata.validate(query)) {
                System.out.println("CHARACTER CONSTANT");
                found=true;
            } 
            if (IntegerAutomata.validate(query)) {
                System.out.println("INTEGER CONSTANT");
                found=true;
            } 
            if (FloatAutomata.validate(query)) {
                System.out.println("FLOAT CONSTANT");
                found=true;
            }
            if (StringAutomata.validate(query)) {
                System.out.println("STRING CONSTANT");
                found=true;
            } 
            
            if(!found)
                System.out.println("INVALID");

            System.out.println("DO YOU WANT TO CONTINUE? (Y/N)");
            check = input.next();
        } while (check.equals("y") || check.equals("Y"));

        
        
        
        
        
        
        
        
        
        
       
   }
   
   
    
}
