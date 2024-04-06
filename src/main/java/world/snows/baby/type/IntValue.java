package world.snows.baby.type;

public class IntValue implements Value<IntValue>, Comparable<IntValue> {
    private final int value;

    public IntValue(int val) {
        value = val;
    }

    @Override
    public IntValue getValue() {
        return this;
    }

    @Override
    public int compareTo(IntValue intValue) {
        return Integer.compare(value, intValue.value);
    }

    @Override
    public String toString(){return String.valueOf(value);}
}
