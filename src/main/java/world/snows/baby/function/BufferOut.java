package world.snows.baby.function;

import world.snows.baby.expression.Expression;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

import java.util.List;

public class BufferOut extends Function {
    public BufferOut() {
        super(null);
    }

    @Override
    public Value<? extends Value<?>> invoke(List<Expression> arguments) {
        for (Expression arg : arguments) {
            System.out.print(arg);
            System.out.flush();
        }

        System.out.print('\n');
        return new NullValue();
    }
}
