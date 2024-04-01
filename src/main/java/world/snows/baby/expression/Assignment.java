package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.Value;

public class Assignment implements Expression {
    private final String identifier;
    private final Expression assignable;

    public Assignment(String name, Expression expr) {
        identifier = name;
        assignable = expr;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) {
        // walrus operator type assignment
        Value<? extends Value<?>> val = assignable.evaluate(inter);
        inter.assignSymbol(identifier, val);
        return val;
    }
}
