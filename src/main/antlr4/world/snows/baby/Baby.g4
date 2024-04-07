grammar Baby;

@header {
import world.snows.baby.expression.*;
import world.snows.baby.type.*;
}

@members {
    private boolean capAsBool(String cap) {
        return cap == "cap" ? false : true;
    }
}

literal returns [Expression exp]
    : INT { $exp = new IntLiteral($INT.text); }
    | DOUBLE {$exp = new DoubleLiteral($DOUBLE.text);}
    | CHAR { $exp = new CharLiteral($CHAR.text); }
    | STRING { $exp = new StringLiteral($STRING.text); }
    | BOOL { $exp = new BoolLiteral($BOOL.text); }
    ;

operator returns [Operator op]
    : '+' { $op = Operator.ADD; }
    | '-' { $op = Operator.SUBTRACT; }
    | '*' { $op = Operator.MULTIPLY; }
    | '/' { $op = Operator.DIVIDE; }
    ;

comparison returns [Comparator cmp]
    : 'be' { $cmp = Comparator.EQUAL; }
    | 'more' 'than' { $cmp = Comparator.GREATER; }
    | 'less' 'than' { $cmp = Comparator.LESS; }
    ;

expression returns [Expression exp]
    : e1=expression op=operator e2=expression { $exp = new Arithmetic($op.op, $e1.exp, $e2.exp); }
    | e1=expression cmp=comparison e2=expression cap=BOOL { $exp = new Comparison($cmp.cmp, $e1.exp, $e2.exp, capAsBool($cap.text)); }
    | 'gimme' 'some' expression { $exp = new Returnable($expression.exp); }
    | 'ima' 'turn' cn=('a' | 'an') ID 'into' 'a' expression { $exp = new Assignment($ID.text, $expression.exp, $cn.text); }
    | { List<String> args = new ArrayList<>(); List<Expression> body = new ArrayList<>();}
          'ima' 'turn' cn=('a' | 'an') ID 'into' 'a' 'function' 'with' (par1=ID { args.add($par1.text); } (',' par2=ID { args.add($par2.text); })*)?
          (statement{ body.add($statement.exp); })+
          'yeah'
          {$exp = new FuncDeclare($ID.text, args, new Block(body));}
    | { List<Expression> args = new ArrayList<>(); }
      'tryna' ID 'with' (e1=expression { args.add($e1.exp); } (',' e2=expression { args.add($e2.exp); })*)? 'rn'
      { $exp = new Invocation($ID.text, args); }
    | literal { $exp = $literal.exp; }
    | ID { $exp = new Dereference($ID.text); }
    ;

conditional returns [Expression exp]
    : { List<Expression> exprs = new ArrayList<>(); }
      'if' cnd=expression
      (statement { exprs.add($statement.exp); })*
      'yeah' { $exp = new Conditional($cnd.exp, exprs); }
    ;

loop returns [Expression exp]
    : { List<Expression> exprs = new ArrayList<>(); }
      'ima' 'do' 'this' 'rq'
      (e=expression { exprs.add($e.exp); })*
      'while' cnd=expression
      { $exp = new Loop($cnd.exp, exprs); }
    ;

statement returns [Expression exp]
    : expression { $exp = $expression.exp; }
    | conditional { $exp = $conditional.exp; }
    | loop { $exp = $loop.exp; }
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
INT : '-'?[0-9]+;
DOUBLE : '-'?[0-9]+ ('.' [0-9]+)?;
CHAR : '\'' [ -~] '\'';
STRING : '"' ~'"' '"';

// stuff that should be left on the very bottom
ID : [a-zA-Z_] [a-zA-Z0-9_]*;

COMMENT : ':)' ~'\n'* -> skip;
