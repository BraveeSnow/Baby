package world.snows.baby.function;

import world.snows.baby.Interpreter;
import world.snows.baby.expression.Expression;
import world.snows.baby.type.ListValue;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class Add extends Function{
    public Add() {
        super(null);
    }

    @Override
    public Value<? extends Value<?>> invoke(Interpreter inter, List<Expression> expressions) throws Exception {
        ((ListValue) expressions.get(0).evaluate(inter)).add(expressions.get(1));
        return new NullValue();
    }
}
