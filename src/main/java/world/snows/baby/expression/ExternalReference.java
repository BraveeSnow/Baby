package world.snows.baby.expression;

import org.antlr.v4.runtime.*;
import world.snows.baby.BabyLexer;
import world.snows.baby.BabyParser;
import world.snows.baby.Interpreter;
import world.snows.baby.type.NullValue;
import world.snows.baby.type.Value;

public class ExternalReference implements Expression {
    private final String referencePath;

    public ExternalReference(String path) {
        referencePath = path + ".baby";
    }

    @Override
    public Value<? extends Value<?>> evaluate(Interpreter inter) throws Exception {
        CharStream externalStream = CharStreams.fromFileName(referencePath);
        Lexer lex = new BabyLexer(externalStream);
        TokenStream tokens = new BufferedTokenStream(lex);
        BabyParser externalBaby = new BabyParser(tokens);

        externalBaby.program().exp.evaluate(inter);
        return new NullValue();
    }
}
