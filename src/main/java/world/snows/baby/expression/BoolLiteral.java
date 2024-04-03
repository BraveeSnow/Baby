package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.Value;

public class BoolLiteral implements Expression{
    private final BoolValue data;

    public BoolLiteral(String lexeme){
        if (lexeme.equals("cap")) {
            data = new BoolValue(false);
        } else {
            data = new BoolValue(true);
        }

    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) {
        return data;
    }
}
