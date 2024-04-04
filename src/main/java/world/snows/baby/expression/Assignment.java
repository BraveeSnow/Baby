package world.snows.baby.expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import world.snows.baby.Interpreter;
import world.snows.baby.type.Value;

import java.util.Objects;

public class Assignment implements Expression {
    private static final Logger LOGGER = LoggerFactory.getLogger(Assignment.class);
    private static final String VOWELS = "AEIOUaeiou";

    private final String identifier;
    private final Expression assignable;

    public Assignment(String name, Expression expr, String connector) {
        identifier = name;
        assignable = expr;

        if ((VOWELS.indexOf(name.charAt(0)) == -1) == Objects.equals(connector, "an")) {
            LOGGER.warn("Incorrect grammar in assignment of {}, please use '{}' instead.", identifier, connector.equals("an") ? "a" : "an");
        }
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        // walrus operator type assignment
        Value<? extends Value<?>> val = assignable.evaluate(inter);
        inter.assignSymbol(identifier, val);
        return val;
    }
}
