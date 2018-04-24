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
public class DFAClosure {

    //Attributes
    DFA dfa;
    ArrayList<Integer[]> AdjacencyMatrix;
    ArrayList<ResultantStateClosure> States;
    boolean InitialIsFinal;

    //Constructor  
    public DFAClosure(DFA dfa) {

        this.dfa = dfa;
        States = new ArrayList<>();
        AdjacencyMatrix = new ArrayList<>();
        InitialIsFinal=false;

    }

    public DFA Closure() {

        
        ArrayList<Integer> StartState = new ArrayList<>();
        if(CheckFinal(StartState))
            InitialIsFinal=true;
            
        StartState.add(dfa.InitialState);
        ResultantStateClosure InitialState = new ResultantStateClosure(StartState);
        States.add(InitialState);
        
            

        for (int i = 0; i < States.size(); i++) {

            AdjacencyMatrix.add(new Integer[dfa.Regexes.length]);

            for (int j = 0; j < dfa.Regexes.length; j++) {

                ArrayList<Integer> Transitions = new ArrayList<>();

                for (int k = 0; k < States.get(i).x.size(); k++) {

                    int NextTransition = dfa.NextState(States.get(i).x.get(k), dfa.Regexes[j].charAt(0));

                    if (!Transitions.contains(NextTransition)) {
                        Transitions.add(NextTransition);
                    }

                }

                if (CheckFinal(Transitions) && !Transitions.contains(dfa.InitialState)) {
                    Transitions.add(dfa.InitialState);
                }

                sort(Transitions);
                ResultantStateClosure State = new ResultantStateClosure(Transitions);

                if (CheckExistence(State) == -1) {

                    States.add(State);
                    AdjacencyMatrix.get(AdjacencyMatrix.size() - 1)[j] = States.size() - 1;

                } else {
                    AdjacencyMatrix.get(AdjacencyMatrix.size() - 1)[j] = CheckExistence(State);
                }

            }

        }
        
         int[][] ResulttantMatrix = new int[AdjacencyMatrix.size()][dfa.Regexes.length];

        for (int i = 0; i < ResulttantMatrix.length; i++) {

            for (int j = 0; j < dfa.Regexes.length; j++) {

                ResulttantMatrix[i][j] = AdjacencyMatrix.get(i)[j];

            }

        }

        String[] allowedChar = new String[dfa.Regexes.length];

        for (int i = 0; i < dfa.Regexes.length; i++) {

            allowedChar[i] = dfa.Regexes[i];
        }

        return new DFA(ResulttantMatrix, allowedChar, 0, FindFinalStates());

    }

    public int CheckExistence(ResultantStateClosure NewState) {

        int i=1;
        if(InitialIsFinal)
          i=0;  
        for (; i < States.size(); i++) {
            if (States.get(i).Comparator(NewState)) {
                return i;
            }
        }
        return -1;

    }

    public boolean CheckFinal(ArrayList<Integer> Transitions) {

        for (int i = 0; i < dfa.FinalStates.length; i++) {
            int search = dfa.FinalStates[i];
            for (int j = 0; j < Transitions.size(); j++) {
                if (Transitions.get(j) == search) {
                    return true;
                }
            }

        }

        return false;

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
    
    
    
       public int[] FindFinalStates() {

        ArrayList<Integer> FinalStates = new ArrayList<>();

        for (int i = 0; i < States.size(); i++) {

            boolean Final = false;

            for (int j = 0; j < dfa.FinalStates.length; j++) {
                int search =dfa.FinalStates[j];
                for (int k = 0; k < States.get(i).x.size(); k++) {
                    if (States.get(i).x.get(k) == search) {
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
    
    
    
    
    
}


