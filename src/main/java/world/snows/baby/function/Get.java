package world.snows.baby.function;

import world.snows.baby.Interpreter;
import world.snows.baby.expression.Expression;
import world.snows.baby.type.ListValue;
import world.snows.baby.type.Value;

import java.util.List;

public class Get extends Function{
    public Get() {
        super(null);
    }

    @Override
    public Value<? extends Value<?>> invoke(Interpreter inter, List<Expression> expressions) throws Exception {
        return ((ListValue) expressions.get(0).evaluate(inter)).getIndex(Integer.parseInt((expressions.get(1).evaluate(inter)).toString())).evaluate(inter);
    }
}
