package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.Value;

public class Comparison implements Expression {
    private final Comparator comparator;
    private final Expression leftSide;
    private final Expression rightSide;

    public Comparison(Comparator cmp, Expression left, Expression right, boolean isCap) {
        comparator = isCap ? cmp.capped() : cmp;
        leftSide = left;
        rightSide = right;
    }

    @Override
    public BoolValue evaluate(Interpreter inter) throws Exception {
        Value<? extends Value<?>> leftVal = leftSide.evaluate(inter);
        Value<? extends Value<?>> rightVal = rightSide.evaluate(inter);

        if (leftVal instanceof Comparable l && rightVal instanceof Comparable r) {
            return new BoolValue(switch (comparator) {
                case EQUAL -> l == r;
                case NOT_EQUAL -> l != r;
                case LESS -> l.compareTo(r) < 0;
                case LESS_EQUAL -> l.compareTo(r) <= 0;
                case GREATER -> l.compareTo(r) > 0;
                case GREATER_EQUAL -> l.compareTo(r) >= 0;
            });
        }

        throw new Exception(String.format("Unable to compare types %s and %s", leftVal.getClass().getSimpleName(), rightVal.getClass().getSimpleName()));
    }
}
