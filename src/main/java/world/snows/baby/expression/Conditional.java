package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class Conditional /*extends Block*/ implements Expression {
    private final List<Expression> conditions;
    private final List<List<Expression>> bodys;
    private final List<Expression> or;

    public Conditional(List<Expression> conditionals, List<List<Expression>> exprs, List<Expression> Or) {
        conditions = conditionals;
        bodys = exprs;
        or = Or;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        for (int condNum = 0; condNum < conditions.size(); condNum++) {
            Value<? extends Value<?>> val = conditions.get(condNum).evaluate(inter);

            if (val instanceof BoolValue && ((BoolValue) val).isTrue()) {
                Block block = new Block(bodys.get(condNum));
                return block.evaluate(inter);
            }
        }

        Block block = new Block(or);

        return block.evaluate(inter);
    }
}
