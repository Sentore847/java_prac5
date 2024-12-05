public class AutomatonProcessor {
    private enum AutomatonState {
        INITIAL, STATE_1, STATE_2, STATE_3, FINAL
    }

    private AutomatonState currentState;

    public AutomatonProcessor() {
        currentState = AutomatonState.INITIAL;
    }

    public int evaluate(String input) {
        currentState = AutomatonState.INITIAL;
        for (char character : input.toCharArray()) {
            switch (currentState) {
                case INITIAL -> currentState = (character == 'T') ? AutomatonState.STATE_1 : AutomatonState.INITIAL;
                case STATE_1 -> currentState = (character == 'E') ? AutomatonState.STATE_2 :
                        (character == 'T' ? AutomatonState.STATE_1 : AutomatonState.INITIAL);
                case STATE_2 -> currentState = (character == 'S') ? AutomatonState.STATE_3 :
                        (character == 'T' ? AutomatonState.STATE_1 : AutomatonState.INITIAL);
                case STATE_3 -> currentState = (character == 'T') ? AutomatonState.FINAL : AutomatonState.INITIAL;
            }
        }
        return currentState.ordinal();
    }

    public boolean isAccepted() {
        return currentState == AutomatonState.FINAL;
    }
}
