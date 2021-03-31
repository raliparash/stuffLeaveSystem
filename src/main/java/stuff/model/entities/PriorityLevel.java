package stuff.model.entities;

public enum  PriorityLevel {

    HIGH(1),
    MEDIUM(2),
    LOW(3);

    private int level;

    PriorityLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
