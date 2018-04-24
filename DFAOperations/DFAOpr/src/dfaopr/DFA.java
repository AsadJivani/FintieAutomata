/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaopr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author asadj
 */

class DFA{

   //attributes 
    
    int InitialState;
    int[] FinalStates;
    int[][] Matrix;
    String[] Regexes;

   
    //constructor
    
    public DFA(int[][] Matrix,String[] Regexes,int InitialState,int[] FinalStates){
    
        this.InitialState=InitialState;
        this.FinalStates=FinalStates;
        this.Matrix=Matrix;
        this.Regexes=Regexes;
    
    
    }
    
       
    //Methods
    
    public boolean validate(String input){
    
        int CurrentState=InitialState;

        for(int i=0; i<input.length(); i++){
        
            if(CurrentState==-1)
                return false;
            CurrentState=NextState(CurrentState, input.charAt(i));
       
        }
        
        for (int i = 0; i < FinalStates.length; i++) 
            if(FinalStates[i]==CurrentState)
                return true;
        return false;
        
    }
    
    
    
    public int NextState(int currentState,char input){
    
        boolean foundregex=false;
        int regexindex=-1;
        Pattern p;
        Matcher m;
        for (int i = 0; i < Regexes.length; i++) {
            p=Pattern.compile(Regexes[i]);
            m=p.matcher(String.valueOf(input));
            if(m.matches()){
                regexindex=i;
                foundregex=true;
                break;
            
            }
                
        }
        
        if(!foundregex)
            return regexindex;
        else
            return Matrix[currentState][regexindex];
        
        
        
        
    
    }
    
    
    
    
    

}












    

