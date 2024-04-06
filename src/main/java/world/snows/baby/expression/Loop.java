package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class Loop implements Expression {
    private final Expression condition;
    private final Block block;

    public Loop(Expression cond, List<Expression> exprs) {
        condition = cond;
        block = new Block(exprs);
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        Value<? extends Value<?>> breakOut = condition.evaluate(inter);

        if (!(breakOut instanceof BoolValue)) {
            throw new Exception("Invalid loop: condition cannot be evaluated as a boolean");
        }

        do {
            block.evaluate(inter);
        } while (((BoolValue) condition.evaluate(inter)).isTrue());

        return new NullValue();
    }
}
