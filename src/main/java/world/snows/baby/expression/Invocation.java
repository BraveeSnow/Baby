package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.function.Builtin;
import world.snows.baby.expression.FuncDeclare;
import world.snows.baby.type.FuncValue;
import world.snows.baby.type.Value;

import java.util.List;

public class Invocation implements Expression {
    private final String identifier;
    private final List<Expression> arguments;

    public Invocation(String id, List<Expression> args) {
        identifier = id;
        arguments = args;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        try {
            return Builtin.call(inter, identifier, arguments);
        } catch (NoSuchMethodError e){
            Value<?> f = inter.retrieveSymbol(identifier);
            if(f.getClass().equals(FuncValue.class)) {
                for (int i = 0; i < arguments.size(); i++) {
                    inter.assignSymbol(((FuncValue) f).getPatameters().get(i), arguments.get(i).evaluate(inter));
                }
                return ((FuncValue) f).getBody().evaluate(inter);
            } else{
                throw new Exception("$identifier is not a function");
            }
        }

    }
}
