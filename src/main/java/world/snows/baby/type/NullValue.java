package world.snows.baby.type;

public class NullValue implements Value<NullValue> {
    @Override
    public NullValue getValue() {
        throw new NullPointerException("Expression evaluated to null");
    }
}
