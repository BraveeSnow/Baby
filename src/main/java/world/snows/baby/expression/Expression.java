package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.Value;

public interface Expression {
    Value<? extends Value<?>> evaluate(Interpreter inter);
}
