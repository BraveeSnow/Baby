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
    | 'gimme' 'some' expression { $exp = new Returnable($expression.exp); }
    | literal { $exp = $literal.exp; }
    | ID { $exp = new Dereference($ID.text); }
    ;

comparison returns [Comparator cmp]
    : 'be' { $cmp = Comparator.EQUAL; }
    | 'more' 'than' { $cmp = Comparator.GREATER; }
    | 'less' 'than' { $cmp = Comparator.LESS; }
    ;

conditional returns [Expression exp]
    : { List<Expression> exprs = new ArrayList<>(); }
      'if' expression comparison expression BOOL
      (statement { exprs.add($statement.exp); })*
      'yeah' { $exp = new Block(exprs); }
    ;

statement returns [Expression exp]
    : expression { $exp = $expression.exp; }
    | conditional { $exp = $conditional.exp; }
    ;

program returns [Expression exp]
    : { List<Expression> exprs = new ArrayList<>(); }
      PROG_START
      (statement { exprs.add($statement.exp); })*
      PROG_END EOF { $exp = new Block(exprs); }
    ;

// antlr god mode
WS : [ \r\n\t] -> skip;

// keywords
PROG_START : 'LESS' WS 'GOOO';
PROG_END : 'YEAH' WS 'YEAH';

// literals
BOOL : 'cap' | 'no' WS 'cap';
INT : [0-9]+;
DOUBLE : [0-9]+ ('.' [0-9]+)?;
CHAR : '\'' [ -~] '\'';
STRING : '"' ~'"' '"';

// stuff that should be left on the very bottom
ID : [a-zA-Z_] [a-zA-Z0-9_]*;

COMMENT : ':)' ~'\n' -> skip;
