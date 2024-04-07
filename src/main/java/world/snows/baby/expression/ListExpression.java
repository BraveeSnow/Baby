package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.ListValue;
import world.snows.baby.type.Value;

import java.util.ArrayList;

public class ListExpression implements Expression {
    private final ListValue value;

    public ListExpression() {
        value = new ListValue(new ArrayList<>());
    }

    public ListExpression(int low, int high) {
        ArrayList<Expression> v = new ArrayList<>();
        for (int i = low; i < high; i++) {
            v.add(new IntLiteral(String.valueOf(i)));
        }
        value = new ListValue(v);
    }

    public ListExpression(ArrayList<Expression> Value) {
        value = new ListValue(Value);
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        return value;
    }
}
