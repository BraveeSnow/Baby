package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class Block implements Expression {
    private final List<Expression> expressions;

    public Block(List<Expression> exprs) {
        expressions = exprs;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) {
        Value<? extends Value<?>> returnValue = new NullValue();

        for (Expression expr : expressions) {
            returnValue = expr instanceof Returnable ? expr.evaluate(inter) : returnValue;
        }

        return returnValue;
    }
}
