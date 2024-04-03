package world.snows.baby.type;

public class BoolValue implements Value<BoolValue>{

    private final boolean value;

    public BoolValue(boolean val) {value = val;}

    @Override
    public BoolValue getValue() {
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof BoolValue) {
            return value == ((BoolValue) other).value;
        }
        return false;
    }
}
