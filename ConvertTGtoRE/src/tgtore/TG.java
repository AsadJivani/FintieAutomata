/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

import java.util.ArrayList;

/**
 *
 * @author asadj
 */
public class TG {

    //attributes
    ArrayList<ArrayList<Object[]>> TT;

    //constructor   
    public TG(ArrayList<ArrayList<Object[]>> TT) {

        this.TT = TT;

    }

    public String TGTORE() {

        int Size = TT.size();

        for (int i = 0; i < Size - 2; i++) {

            ReduceEdges(0);
            eliminate(0);

        }
        ReduceEdges(0);
        return (String) TT.get(0).get(0)[1];
    }

    public void ReduceEdges(int stateno) {

        for (int i = 0; i < TT.get(stateno).size() - 1; i++) {

            for (int j = i + 1; j < TT.get(stateno).size(); j++) {

                if ((int) TT.get(stateno).get(i)[0] == (int) TT.get(stateno).get(j)[0]) {

                    String concat = "("+TT.get(stateno).get(i)[1] + "+" + TT.get(stateno).get(j)[1]+")";
                    int state = (int) TT.get(stateno).get(i)[0];
                    TT.get(stateno).remove(i);
                    //remove j-1 because after removal of i the index of j is decremented by 1
                    TT.get(stateno).remove(j - 1);
                    Object[] transition = {state, concat};
                    TT.get(stateno).add(transition);
                    i = 0;
                    j = 1;
                }

            }

        }
    }

    public void eliminate(int stateno) {

        int loopindex = -1;

        //Find a Loop  
        for (int i = 0; i < TT.get(stateno).size(); i++) {

            if ((int) TT.get(stateno).get(i)[0] == stateno) {
                loopindex = i;
                break;
            }

        }

        //Find IncomingIndex
        for (int i = 0; i < TT.size(); i++) {
            if (i != stateno) {
                ArrayList<Object[]> currentState = TT.get(i);
                for (int j = 0; j < TT.get(i).size(); j++) {

                    if ((int) currentState.get(j)[0] == stateno) {

                        for (int k = 0; k < TT.get(stateno).size(); k++) {

                            if (k != loopindex) {
                                String re = null;
                                if (loopindex == -1) {

//                                    if (((String) currentState.get(j)[1]).equals("") && !(((String) TT.get(stateno).get(k)[1]).equals(""))) {
//                                        re = "(" + TT.get(stateno).get(k)[1] + ")";
//                                    } else if (((String) TT.get(stateno).get(k)[1]).equals("") && !(((String) currentState.get(j)[1]).equals(""))) {
//                                        re = "(" + currentState.get(j)[1] + ")";
//                                    } else if (!((String) currentState.get(j)[1]).equals("") && !(((String) TT.get(stateno).get(k)[1]).equals(""))) {
//                                        re = "(" + currentState.get(j)[1] + ")" + "(" + TT.get(stateno).get(k)[1] + ")";
//                                    } else {
//                                        re = "";
//                                    }
                                    re = (String) currentState.get(j)[1] + TT.get(stateno).get(k)[1];
                                } else {

//                                    if (((String) currentState.get(j)[1]).equals("") && !(((String) TT.get(stateno).get(k)[1]).equals(""))) {
//                                        re = "(" + TT.get(stateno).get(loopindex)[1] + ")" + "*" + "(" + TT.get(stateno).get(k)[1] + ")";
//                                    } else if (((String) TT.get(stateno).get(k)[1]).equals("") && !(((String) currentState.get(j)[1]).equals(""))) {
//                                        re = "(" + currentState.get(j)[1] + ")"+"(" + TT.get(stateno).get(loopindex)[1] + ")*";
//                                    } else if (!((String) currentState.get(j)[1]).equals("") && !(((String) TT.get(stateno).get(k)[1]).equals(""))) {
//                                        re = "(" + currentState.get(j)[1] + ")" + "(" + TT.get(stateno).get(loopindex)[1] + ")" + "*" + "(" + TT.get(stateno).get(k)[1] + ")";
//                                    } else {
//                                        re = "(" + TT.get(stateno).get(loopindex)[1] + ")*";
//                                    }
                                    re =   currentState.get(j)[1] + "(" + TT.get(stateno).get(loopindex)[1] + ")*" + TT.get(stateno).get(k)[1] ;

                                }

                                Object[] obj = {(int) TT.get(stateno).get(k)[0], re};
                                TT.get(i).add(obj);

                            }

                        }
                        TT.get(i).remove(j);

                    }

                }

            }
        }

        TT.remove(stateno);
        Reset(TT);

    }

    public void Reset(ArrayList<ArrayList<Object[]>> TT) {
        for (int i = 0; i < TT.size(); i++) {
            ArrayList<Object[]> current = TT.get(i);
            for (int j = 0; j < current.size(); j++) {
                current.get(j)[0] = (int) current.get(j)[0] - 1;
            }

        }

    }

}
