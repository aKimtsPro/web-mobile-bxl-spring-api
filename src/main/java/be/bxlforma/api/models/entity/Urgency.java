package be.bxlforma.api.models.entity;

public enum Urgency {
    HIGH,
    NORMAL,
    LOW;

    public Urgency up(){
        Urgency up;
        switch (this) {
            case LOW -> up = NORMAL;
            case NORMAL -> up = HIGH;
            default -> throw new RuntimeException("no higher urgency");
        }
        return up;
    }

    public Urgency down(){
        Urgency down;
        switch (this) {
            case NORMAL -> down = LOW;
            case HIGH -> down = NORMAL;
            default -> throw new RuntimeException("no lower urgency");
        }
        return down;
    }
}
