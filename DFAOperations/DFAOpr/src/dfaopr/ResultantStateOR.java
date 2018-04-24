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
public class ResultantStateOR {
    
    int x;
    int y;

    public ResultantStateOR(int x,int y) {
        
        this.x=x;
        this.y=y;
    
    }
    
    
    public boolean Comparator(ResultantStateOR State){
    
        if(this.x==State.x && this.y==State.y)
            return true;
        else 
            return false;
    
    }
    
    
    
}
