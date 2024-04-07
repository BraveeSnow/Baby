package world.snows.baby.expression;

import world.snows.baby.Interpreter;
import world.snows.baby.type.IntValue;
import world.snows.baby.type.StringValue;
import world.snows.baby.type.Value;

public class Arithmetic implements Expression {
    private final Operator operator;
    private final Expression left;
    private final Expression right;

    public Arithmetic(Operator op, Expression leftSide, Expression rightSide) {
        operator = op;
        left = leftSide;
        right = rightSide;
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        Value<? extends Value<?>> leftVal = left.evaluate(inter);
        Value<? extends Value<?>> rightVal = right.evaluate(inter);

        if (leftVal instanceof IntValue l && rightVal instanceof IntValue r) {
            return switch (operator) {
                case ADD -> l.add(r);
                case SUBTRACT -> l.subtract(r);
                case MULTIPLY -> l.multiply(r);
                case DIVIDE -> l.divide(r);
            };
        }

        if (leftVal instanceof StringValue l && rightVal instanceof IntValue r) {
            return switch (operator) {
                case ADD -> l.add(r);
                case MULTIPLY -> l.multiply(r);
                default -> throw new ArithmeticException(
                        String.format("Operator %s cannot be applied to %s and %s",
                                operator, l.getClass().getSimpleName(), r.getClass().getSimpleName()
                        ));
            };
        }

        if (leftVal instanceof StringValue l && rightVal instanceof StringValue r && operator == Operator.ADD) {
            return l.add(r);
        }

        throw new ArithmeticException(String.format("Cannot quick maffs with %s and %s", leftVal.getClass().getSimpleName(), rightVal.getClass().getSimpleName()));
    }
}
