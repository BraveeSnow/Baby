package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.Iterator;
import java.util.List;

public class ForLoop extends Block {
    private final String identifier;
    private final Expression iterator;

    public ForLoop(String id, Expression iter, List<Expression> exprs) {
        super(exprs);
        identifier = id;
        iterator = iter;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        Value<? extends Value<?>> iterValue = iterator.evaluate(inter);
        Block block = new Block(expressions);

        if (!(iterValue instanceof Iterable<?>))  {
            throw new Exception("Invalid loop: expression is not iterable");
        }

        for (Expression expr : (Iterable<Expression>) iterValue) {
            new Assignment(identifier, expr).evaluate(inter);
            block.evaluate(inter);
        }

        return new NullValue();
    }
}
