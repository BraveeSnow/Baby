package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.Value;

public class Returnable implements Expression {
    private final Expression returnable;

    public Returnable(Expression expr) {
        returnable = expr;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        return returnable.evaluate(inter);
    }
}
