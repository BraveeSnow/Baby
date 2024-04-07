package world.snows.baby.type;

public class IntValue implements Value<IntValue>, Comparable<IntValue> {
    protected final int value;

    public IntValue(int val) {
        value = val;
    }

    public IntValue add(IntValue val) {
        return new IntValue(value + val.value);
    }

    public IntValue subtract(IntValue val) {
        return new IntValue(value - val.value);
    }

    public IntValue multiply(IntValue val) {
        return new IntValue(value * val.value);
    }

    public IntValue divide(IntValue val) {
        return new IntValue(value / val.value);
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
