package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

public class Dereference implements Expression {
    private final String identifier;

    public Dereference(String id) {
        identifier = id;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) {
        Value<? extends Value<?>> val = inter.retrieveSymbol(identifier);
        return val != null ? val : new NullValue();
    }
}
