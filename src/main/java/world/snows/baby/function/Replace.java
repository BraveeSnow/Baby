package world.snows.baby.function;

import world.snows.baby.Interpreter;
import world.snows.baby.expression.Expression;
import world.snows.baby.type.ListValue;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class Replace extends Function{
    public Replace() {
        super(null);
    }

    @Override
    public Value<? extends Value<?>> invoke(Interpreter inter, List<Expression> expressions) throws Exception {
        ((ListValue) expressions.get(0).evaluate(inter)).setIndex(Integer.parseInt((expressions.get(1).evaluate(inter)).toString()), expressions.get(2));
        return new NullValue();
    }
}
