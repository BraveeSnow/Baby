package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.function.Builtin;
import world.snows.baby.type.Value;

import java.util.List;

public class Invocation implements Expression {
    private final String identifier;
    private final List<Expression> arguments;

    public Invocation(String id, List<Expression> args) {
        identifier = id;
        arguments = args;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        System.out.println(identifier);
        return Builtin.call(identifier, arguments);
    }
}
