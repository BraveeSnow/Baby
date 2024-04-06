package world.snows.baby.type;

import world.snows.baby.expression.Block;
import world.snows.baby.expression.Expression;

import java.util.List;

public class FuncValue implements Value<FuncValue>{
    private final String name;
    private final List<String> parameters;
    private final Block body;

    public FuncValue(String Name, List<String> Parameters, Block Body){
        name = Name;
        parameters = Parameters;
        body = Body;
    }

    public Block getBody() {
        return body;
    }

    public List<String> getPatameters() {
        return parameters;
    }

    @Override
    public FuncValue getValue() { return this; }

}
