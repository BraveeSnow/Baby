package world.snows.baby.type;

import world.snows.baby.expression.Expression;

import java.util.ArrayList;

public class ListValue implements Value<ListValue>{
    private ArrayList<Expression> value;

    public ListValue(ArrayList<Expression> Vals){
        value = Vals;
    }
    @Override
    public ListValue getValue() {
        return this;
    }
    @Override
    public String toString(){
        return value.toString();
    }
}
