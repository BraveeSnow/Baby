package world.snows.baby;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Objects;

public class InterpreterTest {
    @Test
    void runFactorial() throws Exception {
        evaluateFile("factorial.baby");
    }

    @Test
    void runFor() throws Exception {
        evaluateFile("for.baby");
    }

    void evaluateFile(String fileName) throws Exception {
        Lexer lex = new BabyLexer(CharStreams.fromStream(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName))));
        TokenStream tokens = new BufferedTokenStream(lex);
        BabyParser parser = new BabyParser(tokens);
        parser.program().exp.evaluate(new Interpreter());
    }
}
