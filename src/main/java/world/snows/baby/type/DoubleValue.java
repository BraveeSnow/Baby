package world.snows.baby.type;

public class DoubleValue implements Value<DoubleValue>, Comparable<DoubleValue> {
    private final double value;

    public DoubleValue(double val) {
        value = val;
    }

    @Override
    public DoubleValue getValue() {
        return this;
    }

    @Override
    public int compareTo(DoubleValue DoubleValue) {
        return Double.compare(value, DoubleValue.value);
    }
}