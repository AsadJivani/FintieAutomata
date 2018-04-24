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
public class DFAOR {

   //Attributes
     
   DFA F1;
   DFA F2;
   ArrayList<Integer[]> AdjacencyMatrix;
   ArrayList<ResultantStateOR> States;
    
   
   //Constructor  
     
    public DFAOR(DFA F1,DFA F2){
 
        this.F1=F1;
        this.F2=F2;
        States=new ArrayList<>();
        AdjacencyMatrix=new ArrayList<>();
       
    }
    
  
    
    
    
    public DFA OR(){
        
        
        ResultantStateOR InitialState=new ResultantStateOR(F1.InitialState, F2.InitialState);
        States.add(InitialState);
        
        
        for (int i = 0; i < States.size(); i++) {
  
            
            AdjacencyMatrix.add(new Integer[F1.Regexes.length]);
            
            for (int j = 0; j <F1.Regexes.length ; j++) {
                
                ResultantStateOR State=new ResultantStateOR(F1.NextState(States.get(i).x, F1.Regexes[j].charAt(0)), F2.NextState(States.get(i).y, F1.Regexes[j].charAt(0)));
                if(CheckExistence(State) == -1){
                
                States.add(State);
                AdjacencyMatrix.get(AdjacencyMatrix.size()-1)[j]=States.size()-1;
            
            }else
                AdjacencyMatrix.get(AdjacencyMatrix.size()-1)[j]=CheckExistence(State);
           
            }
        }
        
        
        
        int[][] ResulttantMatrix=new int[AdjacencyMatrix.size()][F1.Regexes.length];
        
        for (int i = 0; i < ResulttantMatrix.length; i++) {
            
            for (int j = 0; j < F1.Regexes.length; j++) {
                
                ResulttantMatrix[i][j]=AdjacencyMatrix.get(i)[j];
            
            
            }
 
            
        }
        
        String[] allowedChar=new String[F1.Regexes.length];
        
        for (int i = 0; i < F1.Regexes.length; i++) {
            
            allowedChar[i]=F1.Regexes[i];
        }
        
        
        return new DFA(ResulttantMatrix,allowedChar,0,FindFinalStates());
        
        
    }
    
    
    public int CheckExistence(ResultantStateOR NewState){
    
       
        
        for (int i = 0; i < States.size(); i++)
              if(States.get(i).Comparator(NewState))
                    return i;
        return -1;
    
    }
    
    public int[] FindFinalStates(){
    
    
       
       ArrayList<Integer> FinalStates=new ArrayList<>();
       
        for (int i = 0; i < States.size(); i++) {
            
            boolean Final=false;
            
            for (int j = 0; j < F1.FinalStates.length; j++) {
                  if(States.get(i).x==F1.FinalStates[j]){
                            Final=true;
                            break;    
                  }
            }
            
            for (int j = 0; j < F2.FinalStates.length; j++) {
                  if(States.get(i).y==F2.FinalStates[j]){
                            Final=true;
                            break;    
                  }
            }
        
            if(Final)
                FinalStates.add(i);
        }
        
       
        int[] Final=new int[FinalStates.size()];
        
        for (int i = 0; i < Final.length; i++) {
            Final[i]=FinalStates.get(i);
        }
        
        
        return Final;
    }
    
    
}
