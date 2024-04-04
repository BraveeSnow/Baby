package world.snows.baby;

import org.antlr.v4.runtime.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // expect first arg to be a .baby file for now
        if (args.length == 0) {
            System.err.println("USAGE: baby <FILEPATH>");
            return;
        }

        try {
            CharStream stream = CharStreams.fromFileName(args[0]);
            LOGGER.debug("Successfully read from file '{}'", args[0]);

            Lexer lex = new BabyLexer(stream);
            TokenStream tokens = new BufferedTokenStream(lex);
            BabyParser baby = new BabyParser(tokens);

            baby.program().exp.evaluate(new Interpreter());
        } catch (IOException e) {
            LOGGER.error("Unable to read from file '{}': it does not exist", args[0]);
        } catch (Exception e) {
            LOGGER.error("Unable to evaluate expression: {}", e.getMessage());
        }
    }
}
