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
public class ResultantState {
    
    int x;
    int y;

    public ResultantState(int x,int y) {
        
        this.x=x;
        this.y=y;
    
    }
    
    
    public boolean Comparator(ResultantState State){
    
        if(this.x==State.x && this.y==State.y)
            return true;
        else 
            return false;
    
    }
    
    
    
}
