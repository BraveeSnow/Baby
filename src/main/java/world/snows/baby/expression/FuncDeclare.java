package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.FuncValue;
import world.snows.baby.type.Value;

import java.util.List;

public class FuncDeclare implements Expression{
    private final FuncValue func;
    private final String name;

    public FuncDeclare(String Name, List<String> Parameters, Block Body) {
        func = new FuncValue(Name, Parameters, Body);
        name = Name;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        inter.assignSymbol(name, func);
        return null;
    }
}
