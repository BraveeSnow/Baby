package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.StringValue;
import world.snows.baby.type.Value;

public class StringLiteral implements Expression {
    private final StringValue value;

    public StringLiteral(String lexeme) {
        value = new StringValue(lexeme.substring(1, lexeme.length() - 1));
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) {
        return value;
    }
}
