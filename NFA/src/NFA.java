/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author asadj
 */
public class NFA {
    
    //attributes 
    
    int InitialState;
    int[] FinalStates;
    ArrayList<ArrayList<Object[]>> TT;
///    String[] Regexes;
    Stack<Integer> States;
    Stack<Integer> Transitions;

   
    //constructor
    
    public NFA(ArrayList<ArrayList<Object[]>> TT,int InitialState,int[] FinalStates){
    
        this.InitialState=InitialState;
        this.FinalStates=FinalStates;
        this.TT=TT;
        States=new Stack<>();
        Transitions=new Stack<>();
    
    }
    public boolean validate(String input){
    
    int i=0;
    int CurrentState=InitialState;
    int PreviousState;
    int preIndex=0;
        while(true){
            
            while(i<input.length()){
                  
                
                PreviousState=CurrentState;
                CurrentState=NextState(CurrentState, input.charAt(i),preIndex);
                if(CurrentState==-1){
                    i--;
                    if(States.isEmpty())    
                     return false;
                    CurrentState=States.pop();
                    preIndex=Transitions.pop();
                   }
                else{
                    i++;
                    States.push(PreviousState);
                    preIndex=0;
                }
            
            
            
            }
        
        boolean Finalstate=false;
            
        for (int j = 0; j < FinalStates.length; j++) {
            if(FinalStates[j]==CurrentState){
                    Finalstate=true;
                    break;
            }
        }
            if(Finalstate) {
                return true;
            }else{
            
                i--;
                if(!States.isEmpty()){
                CurrentState=States.pop();
                preIndex=Transitions.pop();
                }else 
                    return false;
            
            }
                
        
        
        }
       
        
    }
    
    
    
    public int NextState(int currentState,char input,int preIndex){
    
        boolean foundregex=false;
        int regexindex=-1;
        int i=0;
        Pattern p;
        Matcher m;
       
           
        for (i = preIndex; i < TT.get(currentState).size(); i++) {
           
            
            p=Pattern.compile((String)TT.get(currentState).get(i)[1]);
            m=p.matcher(String.valueOf(input));
            if(m.matches()){
                Transitions.push(i+1);
                regexindex=i;
                foundregex=true;
                break;
            
            
        }  
        }
        
        if(!foundregex)
            return regexindex;
        else
            return (int)TT.get(currentState).get(i)[0];
        
       
        
    
    }
    
}
