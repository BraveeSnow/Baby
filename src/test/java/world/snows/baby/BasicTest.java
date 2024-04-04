package world.snows.baby;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Objects;

public class BasicTest {
    private static final InputStream PROGRAM = Thread.currentThread().getContextClassLoader().getResourceAsStream("basic.baby");

    @BeforeAll
    static void isReadable() {
        assert PROGRAM != null;
    }

    @Test
    void runBasic() throws Exception {
        Lexer lex = new BabyLexer(CharStreams.fromStream(Objects.requireNonNull(PROGRAM)));
        TokenStream tokens = new BufferedTokenStream(lex);
        BabyParser parser = new BabyParser(tokens);
        parser.program().exp.evaluate(new Interpreter());
    }
}
