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
public class ResultantStateClosure {

    ArrayList<Integer> x;

    public ResultantStateClosure(ArrayList<Integer> x) {

        this.x = x;

    }

   
    public boolean Comparator(ResultantStateClosure State) {

      if(State.x.size()==x.size()){  
        for (int i = 0; i < this.x.size(); i++) {
            if (this.x.get(i) != State.x.get(i)) {
                return false;
            }
        }
         return true;
      }else
          return false;
       

    }

}
