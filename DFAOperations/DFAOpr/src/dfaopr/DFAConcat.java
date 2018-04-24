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
public class DFAConcat {

    //Attributes
    DFA F1;
    DFA F2;
    ArrayList<Integer[]> AdjacencyMatrix;
    ArrayList<ResultantStateConcat> States;

    //Constructor  
    public DFAConcat(DFA F1, DFA F2) {

        this.F1 = F1;
        this.F2 = F2;
        States = new ArrayList<>();
        AdjacencyMatrix = new ArrayList<>();

    }

    public DFA AND() {

        ArrayList<Integer> Ystates = new ArrayList<>();

        if (CheckFinal(F1.InitialState)) {
            Ystates.add(F2.InitialState);
        }
        ResultantStateConcat InitialState = new ResultantStateConcat(F1.InitialState, Ystates);
        States.add(InitialState);

        for (int i = 0; i < States.size(); i++) {

            AdjacencyMatrix.add(new Integer[F1.Regexes.length]);

            for (int j = 0; j < F1.Regexes.length; j++) {

                ArrayList<Integer> yvalues = new ArrayList<Integer>();
                int xvalue = F1.NextState(States.get(i).x, F1.Regexes[j].charAt(0));

                for (int k = 0; k < States.get(i).y.size(); k++) {

                    int NextTransition = F2.NextState(States.get(i).y.get(k), F1.Regexes[j].charAt(0));

                    if (!yvalues.contains(NextTransition)) {
                        yvalues.add(NextTransition);
                    }

                }

                if (CheckFinal(xvalue) && !yvalues.contains(F2.InitialState)) {
                    yvalues.add(F2.InitialState);
                }

                sort(yvalues);
                ResultantStateConcat State = new ResultantStateConcat(xvalue, yvalues);

                if (CheckExistence(State) == -1) {

                    States.add(State);
                    AdjacencyMatrix.get(AdjacencyMatrix.size() - 1)[j] = States.size() - 1;

                } else {
                    AdjacencyMatrix.get(AdjacencyMatrix.size() - 1)[j] = CheckExistence(State);
                }

            }

        }

        int[][] ResulttantMatrix = new int[AdjacencyMatrix.size()][F1.Regexes.length];

        for (int i = 0; i < ResulttantMatrix.length; i++) {

            for (int j = 0; j < F1.Regexes.length; j++) {

                ResulttantMatrix[i][j] = AdjacencyMatrix.get(i)[j];

            }

        }

        String[] allowedChar = new String[F1.Regexes.length];

        for (int i = 0; i < F1.Regexes.length; i++) {

            allowedChar[i] = F1.Regexes[i];
        }

        return new DFA(ResulttantMatrix, allowedChar, 0, FindFinalStates());

    }

    public int CheckExistence(ResultantStateConcat NewState) {

        for (int i = 0; i < States.size(); i++) {
            if (States.get(i).Comparator(NewState)) {
                return i;
            }
        }
        return -1;

    }

    public int[] FindFinalStates() {

        ArrayList<Integer> FinalStates = new ArrayList<>();

        for (int i = 0; i < States.size(); i++) {

            boolean Final = false;

            for (int j = 0; j < F2.FinalStates.length; j++) {
                int search = F2.FinalStates[j];
                for (int k = 0; k < States.get(i).y.size(); k++) {
                    if (States.get(i).y.get(k) == search) {
                        Final = true;
                        break;
                    }
                }

                if (Final) {
                    break;
                }

            }

            if (Final) {
                FinalStates.add(i);
            }
        }

        int[] Final = new int[FinalStates.size()];

        for (int i = 0; i < Final.length; i++) {
            Final[i] = FinalStates.get(i);
        }

        return Final;
    }

    public void sort(ArrayList<Integer> List) {

        for (int i = 0; i < List.size(); i++) {

            for (int j = i + 1; j < List.size(); j++) {
                if (List.get(i) > List.get(j)) {

                    int temp = List.get(i);
                    List.set(i, List.get(j));
                    List.set(j, temp);

                }

            }

        }

    }

    public boolean CheckFinal(int state) {

        for (int i = 0; i < F1.FinalStates.length; i++) {

            if (state == F1.FinalStates[i]) {
                return true;
            }

        }
        return false;
    }
}
