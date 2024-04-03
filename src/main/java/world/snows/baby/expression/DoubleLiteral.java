package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.DoubleValue;
import world.snows.baby.type.Value;

public class DoubleLiteral implements Expression {
    private final DoubleValue data;

    public DoubleLiteral(String lexeme) {
        data = new DoubleValue(Double.parseDouble(lexeme));
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) {
        return data;
    }
}
