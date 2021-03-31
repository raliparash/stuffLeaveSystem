package stuff.model.entities;

public enum TypeLeave {

    PAID_VACATION(1),
    UNPAID_VACATION(2),
    SICKNESS(3),
    MATERNITY_LEAVE(4),
    PUBLIC_HOLIDAY(5),
    BONUS_DAY(6),
    MARRIAGE_DEAD(7),
    OTHER(8);

    private int value;

    TypeLeave(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
