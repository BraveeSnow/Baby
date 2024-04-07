package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class DoWhileLoop extends Block {
    private final Expression condition;

    public DoWhileLoop(Expression cond, List<Expression> exprs) {
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

        do {
            block.evaluate(inter);
        } while (((BoolValue) condition.evaluate(inter)).isTrue());

        return new NullValue();
    }
}
