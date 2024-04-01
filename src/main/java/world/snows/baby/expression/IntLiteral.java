package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.IntValue;
import world.snows.baby.type.Value;

public class IntLiteral implements Expression {
    private final IntValue data;

    public IntLiteral(String lexeme) {
        data = new IntValue(Integer.parseInt(lexeme));
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) {
        return data;
    }
}
