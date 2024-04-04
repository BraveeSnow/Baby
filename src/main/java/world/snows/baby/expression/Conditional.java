package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class Conditional extends Block {
    private final Expression condition;

    public Conditional(Expression conditional, List<Expression> exprs) {
        super(exprs);
        condition = conditional;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        Value<? extends Value<?>> val = condition.evaluate(inter);

        if (val instanceof BoolValue && ((BoolValue) val).isTrue()) {
            return super.evaluate(inter);
        }

        return new NullValue();
    }
}
