grammar Baby;

@header {
import world.snows.baby.expression.*;
import world.snows.baby.type.*;
}

literal returns [Expression exp]
    : INT { $exp = new IntLiteral($INT.text); }
    | DOUBLE {$exp = new DoubleLiteral($DOUBLE.text);}
    | CHAR { $exp = new CharLiteral($CHAR.text); }
    | STRING { $exp = new StringLiteral($STRING.text); }
    ;

expression returns [Expression exp]
    : 'ima' 'turn' ('a' | 'an') ID 'into' 'a' expression { $exp = new Assignment($ID.text, $expression.exp); }
    | conditional
    | literal
    ;

conditional
    : 'if' comparison BOOL
      statement*
      'yeah'
    ;
comparison returns [Expression bool]
    : comparable ('be'|'more than'|'less than') comparable {$bool = new BoolLiteral("no cap"); }
    ;

comparable
    : ID
    | DOUBLE
    | INT
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
BOOL : 'cap' | 'no cap';
INT : [0-9]+;
DOUBLE : [0-9]+ ('.' [0-9]+)?;
CHAR : '\'' [ -~] '\'';
STRING : '"' ~'"' '"';

// stuff that should be left on the very bottom
ID : [a-zA-Z_] [a-zA-Z0-9_]*;

COMMENT : ':)' ~'\n' -> skip;
WS : [ \r\n\t] -> skip;
