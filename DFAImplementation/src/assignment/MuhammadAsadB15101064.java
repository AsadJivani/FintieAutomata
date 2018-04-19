/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;



/**
 *
 * @author asadj
 */

class FiniteAutomata{

   //attributes 
    
    int InitialState;
    int[] FinalStates;
    int[][] Matrix;
    char[] noofinputs;

   
    //constructor
    
    public FiniteAutomata(int[][] Matrix,char[] noofinputs,int InitialState,int[] FinalStates){
    
        this.InitialState=InitialState;
        this.FinalStates=FinalStates;
        this.Matrix=Matrix;
        this.noofinputs=noofinputs;
    
    
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
    
        boolean foundchar=false;
        int charindex=-1;
        for (int i = 0; i < noofinputs.length; i++) {
            if(noofinputs[i]==input){
                charindex=i;
                foundchar=true;
                break;
            
            }
                
        }
        
        if(!foundchar)
            return charindex;
        else
            return Matrix[currentState][charindex];
        
        
        
        
    
    }
    
    
    
    
    

}











public class MuhammadAsadB15101064 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Demo for even-even finite automata
        
       
        char[] inputs={'a','b'};
        int InitialState=0;
        int[] FinalStates={0};
        int[][] Matrix={{2,1},{3,0},{0,3},{1,2}};
        
        
        FiniteAutomata demo=new FiniteAutomata(Matrix,inputs, InitialState, FinalStates);
        System.out.println((demo.validate("abababababab")==true) ? "Valid String" : "Invalid String" );
    
   }
    
}
