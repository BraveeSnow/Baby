package world.snows.baby.function;

import world.snows.baby.Interpreter;
import world.snows.baby.expression.Expression;
import world.snows.baby.type.Value;

import java.util.List;

public abstract class Function {
    protected final List<Expression> parameters;

    public Function(List<Expression> args) {
        parameters = args;
    }

    public abstract Value<? extends Value<?>> invoke(Interpreter inter, List<Expression> expressions) throws Exception;
}
