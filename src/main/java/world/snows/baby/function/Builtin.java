package world.snows.baby.function;

import world.snows.baby.expression.Expression;
import world.snows.baby.type.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Builtin {
    private static final Map<String, Function> functions;

    static {
        functions = new HashMap<>();
        functions.put("print", new BufferOut());
    }

    public static Value<? extends Value<?>> call(String identifier, List<Expression> args) {
        Function func = functions.get(identifier);

        if (func == null) {
            throw new NoSuchMethodError(String.format("Function '%s' does not exist", identifier));
        }

        return func.invoke(args);
    }
}