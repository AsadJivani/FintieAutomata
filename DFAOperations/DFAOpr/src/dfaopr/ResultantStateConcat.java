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
public class ResultantStateConcat {

    int x;
    ArrayList<Integer> y;

    public ResultantStateConcat(int x, ArrayList<Integer> y) {

        this.x = x;
        this.y = y;

    }

    public boolean Comparator(ResultantStateConcat State) {

        if (this.x == State.x && this.y.size() == State.y.size()) {

            for (int i = 0; i < this.y.size(); i++) {
                if (this.y.get(i) != State.y.get(i)) {
                    return false;
                }
            }

            return true;

        } else {
            return false;
        }
    }
}
