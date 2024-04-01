package world.snows.baby;

import world.snows.baby.type.Value;

import java.util.HashMap;
import java.util.Map;

public final class Interpreter {
    private final Map<String, Value<? extends Value<?>>> symbolTable;

    public Interpreter() {
        symbolTable = new HashMap<>();
    }

    public void assignSymbol(String symbolName, Value<? extends Value<?>> val) {
        symbolTable.put(symbolName, val);
    }

    public Value<?> retrieveSymbol(String symbolName) {
        return symbolTable.get(symbolName);
    }
}
