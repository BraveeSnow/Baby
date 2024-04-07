package world.snows.baby.type;

public class StringValue implements Value<StringValue> {
    private final String value;

    public StringValue(String val) {
        value = val;
    }

    public StringValue add(StringValue val) {
        return new StringValue(value + val.value);
    }

    public StringValue add(IntValue val) {
        return new StringValue(value + val.value);
    }

    public StringValue multiply(IntValue val) {
        return new StringValue(value.repeat(val.value));
    }

    @Override
    public StringValue getValue() {
        return this;
    }

    @Override
    public String toString(){return value;}
}
