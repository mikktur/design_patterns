package state;

public enum Action {
    TRAIN("1"),
    MEDITATE("2"),
    FIGHT("3"),
    INVALID("");

    private final String code;

    Action(String code) {
        this.code = code;
    }

    public static Action fromCode(String code) {
        for (Action action : values()) {
            if (action.code.equals(code)) {
                return action;
            }
        }
        return INVALID;
    }
}
