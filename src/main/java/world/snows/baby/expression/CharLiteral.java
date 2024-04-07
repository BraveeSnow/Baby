package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.CharValue;
import world.snows.baby.type.Value;

public class CharLiteral implements Expression {
    private final CharValue value;

    public CharLiteral(String lexeme) {
        // char is guaranteed at lexeme position 1
        value = new CharValue(lexeme.charAt(1));
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) {
        return value;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
