package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.BoolValue;
import world.snows.baby.type.Value;

public class Comparison implements Expression {
    private final Expression leftSide;
    private final Expression rightSide;
    private final BoolLiteral noCapped;
    private Comparator comparator;

    public Comparison(Comparator cmp, Expression left, Expression right, BoolLiteral noCap) {
        leftSide = left;
        rightSide = right;
        noCapped = noCap;
        comparator = cmp;
    }

    @Override
    public BoolValue evaluate(Interpreter inter) throws Exception {
        Value<? extends Value<?>> leftVal = leftSide.evaluate(inter);
        Value<? extends Value<?>> rightVal = rightSide.evaluate(inter);
        Comparator cmp = ((BoolValue)noCapped.evaluate(inter)).isTrue() ? comparator : comparator.capped();

        if (leftVal instanceof Comparable l && rightVal instanceof Comparable r) {
            return new BoolValue(switch (cmp) {
                case EQUAL -> l.compareTo(r) == 0;
                case NOT_EQUAL -> l.compareTo(r) != 0;
                case LESS -> l.compareTo(r) < 0;
                case LESS_EQUAL -> l.compareTo(r) <= 0;
                case GREATER -> l.compareTo(r) > 0;
                case GREATER_EQUAL -> l.compareTo(r) >= 0;
            });
        }

        throw new Exception(String.format("Unable to compare types %s and %s", leftVal.getClass().getSimpleName(), rightVal.getClass().getSimpleName()));
    }
}
