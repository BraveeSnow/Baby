package world.snows.baby.type;

public class StringValue implements Value<StringValue> {
    private final String value;

    public StringValue(String val) {
        value = val;
    }

    @Override
    public StringValue getValue() {
        return this;
    }
}
