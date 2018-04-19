/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaor;

import java.util.ArrayList;

/**
 *
 * @author asadj
 */
 class DFAOR {

   //Attributes
     
   DFA F1;
   DFA F2;
   ArrayList<Integer[]> AdjacencyMatrix;
   ArrayList<ResultantState> States;
    
   
   //Constructor  
     
    public DFAOR(DFA F1,DFA F2){
 
        this.F1=F1;
        this.F2=F2;
        States=new ArrayList<>();
        AdjacencyMatrix=new ArrayList<>();
       
    }
    
  
    
    
    
    public DFA OR(){
        
        
        ResultantState InitialState=new ResultantState(F1.InitialState, F2.InitialState);
        States.add(InitialState);
        
        
        for (int i = 0; i < States.size(); i++) {
            
            AdjacencyMatrix.add(new Integer[2]);
            
            ResultantState State1=new ResultantState(F1.NextState(States.get(i).x, 'a'), F2.NextState(States.get(i).y, 'a'));
            ResultantState State2=new ResultantState(F1.NextState(States.get(i).x, 'b'), F2.NextState(States.get(i).y, 'b'));
            
            if(CheckExistence(State1) == -1){
                
                States.add(State1);
                AdjacencyMatrix.get(AdjacencyMatrix.size()-1)[0]=States.size()-1;
            
            }else
                AdjacencyMatrix.get(AdjacencyMatrix.size()-1)[0]=CheckExistence(State1);
           
             if(CheckExistence(State2) == -1){
                
                States.add(State2);
                AdjacencyMatrix.get(AdjacencyMatrix.size()-1)[1]=States.size()-1;
            
            }else
                AdjacencyMatrix.get(AdjacencyMatrix.size()-1)[1]=CheckExistence(State2);
            
            
            
            
        }
        
        
        
        int[][] ResulttantMatrix=new int[AdjacencyMatrix.size()][2];
        
        for (int i = 0; i < ResulttantMatrix.length; i++) {
            
            ResulttantMatrix[i][0]=AdjacencyMatrix.get(i)[0];
            ResulttantMatrix[i][1]=AdjacencyMatrix.get(i)[1];
            
        }
        
        
        return new DFA(ResulttantMatrix, new String[]{"a","b"}, 0, FindFinalStates());
        
        
    }
    
    
    public int CheckExistence(ResultantState NewState){
    
       
        
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
