package world.snows.baby.type;

public interface Value<T extends Value<T>> {
    T getValue();
}
