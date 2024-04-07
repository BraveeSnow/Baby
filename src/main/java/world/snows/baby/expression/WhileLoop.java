package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class WhileLoop extends Block {
    private final Expression condition;

    public WhileLoop(Expression cond, List<Expression> exprs) {
        super(exprs);
        condition = cond;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        Value<? extends Value<?>> breakOut = condition.evaluate(inter);
        Block block = new Block(expressions);

        if (!(breakOut instanceof BoolValue)) {
            throw new Exception("Invalid loop: condition cannot be evaluated as a boolean");
        }

        while (((BoolValue) breakOut).isTrue()) {
            block.evaluate(inter);
            breakOut = condition.evaluate(inter);
        }

        return new NullValue();
    }
}
