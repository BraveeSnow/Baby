package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.Value;

public class BoolLiteral implements Expression{
    private final BoolValue value;

    public BoolLiteral(boolean bool) {
        value = new BoolValue(bool);
    }

    public BoolLiteral(String lexeme){
        if (lexeme.equals("cap")) {
            value = new BoolValue(false);
        } else {
            value = new BoolValue(true);
        }
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
