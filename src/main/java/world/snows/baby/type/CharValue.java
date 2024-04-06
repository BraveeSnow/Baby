package world.snows.baby.type;

public class CharValue implements Value<CharValue>, Comparable<CharValue> {
    private final char value;

    public CharValue(char c) {
        value = c;
    }

    @Override
    public CharValue getValue() {
        return this;
    }

    @Override
    public int compareTo(CharValue charValue) {
        return Character.compare(value, charValue.value);
    }

    @Override
    public String toString() {return String.valueOf(value);}
}
