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

    public List<Expression> getBlock() {
        return expressions;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        Value<? extends Value<?>> returnValue = new NullValue();

        for (Expression expr : expressions) {
            Value<? extends Value<?>> val = expr.evaluate(inter);
            if (expr instanceof Conditional && !val.getClass().equals(NullValue.class)) {
                return val;
            }
            returnValue = expr instanceof Returnable ? val : returnValue;
            if (!returnValue.getClass().equals(NullValue.class)){
                return returnValue;
            }
        }

        return returnValue;
    }
}
