grammar Baby;

@header {
import world.snows.baby.expression.*;
}

literal returns [Expression exp]
    : INT { $exp = new IntLiteral($INT.text); }
    | CHAR
    | STRING { $exp = new StringLiteral($STRING.text); }
    ;

expression returns [Expression exp]
    : 'ima' 'turn' ('a' | 'an') ID 'into' 'a' expression { $exp = new Assignment($ID.text, $expression.exp); }
    | literal
    ;

statement
    : expression
    ;

program returns [Expression exp]
    : PROG_START
      statement*
      PROG_END
      EOF
    ;

// keywords
PROG_START : 'LESS' 'GOOO';
PROG_END : 'YEAH' 'YEAH';

// literals
INT : [0-9]+;
CHAR : '\'' [ -~] '\'';
STRING : '"' ~'"' '"';

// stuff that should be left on the very bottom
ID : [a-zA-Z_] [a-zA-Z0-9_]*;

WS : [ \r\n\t] -> skip;
