package world.snows.baby.type;

import world.snows.baby.expression.Expression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListValue implements Value<ListValue>, Iterable<Expression> {
    private final ArrayList<Expression> value;

    public ListValue(ArrayList<Expression> vals){
        value = vals;
    }
    @Override
    public ListValue getValue() {
        return this;
    }
    @Override
    public String toString(){
        return value.toString();
    }

    @Override
    public Iterator<Expression> iterator() {
        return value.iterator();
    }

    @Override
    public void forEach(Consumer<? super Expression> action) {
        value.forEach(action);
    }

    @Override
    public Spliterator<Expression> spliterator() {
        return value.spliterator();
    }
    public Expression getIndex(int index){
        return value.get(index);
    }

    public void setIndex(int index, Expression ex){
        value.set(index, ex);
    }

    public Expression removeIndex(int index){
        return value.remove(index);
    }
    public void add(Expression ex){
        value.add(ex);
    }
}
