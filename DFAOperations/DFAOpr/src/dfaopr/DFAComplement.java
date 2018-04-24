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
class DFAComplement {

    DFA dfa;

    public DFAComplement(DFA dfa) {

        this.dfa = dfa;

    }

    public DFA Complement() {

        int[] FinalStates = new int[dfa.Matrix.length - dfa.FinalStates.length];

        int StateNo = 0;

        for (int i = 0; i < FinalStates.length; i++) {

            boolean isFinal = false;

            for (int j = 0; j < dfa.FinalStates.length; j++) {
                if (StateNo == dfa.FinalStates[j]) {
                    isFinal = true;
                }

            }

            if (!isFinal) {
                FinalStates[i] = StateNo;
            } else {
                i--;
            }

            StateNo++;

        }

        return new DFA(dfa.Matrix, dfa.Regexes, dfa.InitialState, FinalStates);

    }

}
