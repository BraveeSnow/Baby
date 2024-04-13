grammar Baby;

@header {
import world.snows.baby.expression.*;
import world.snows.baby.type.*;
}

bool returns [Expression exp]
    : 'no' 'cap' { $exp = new BoolLiteral(true); }
    | 'cap' { $exp = new BoolLiteral(false); }
    ;

literal returns [Expression exp]
    : INT { $exp = new IntLiteral($INT.text); }
    | DOUBLE {$exp = new DoubleLiteral($DOUBLE.text);}
    | CHAR { $exp = new CharLiteral($CHAR.text); }
    | STRING { $exp = new StringLiteral($STRING.text); }
    | bool { $exp = $bool.exp; }
    ;

operator returns [Operator op]
    : '+' { $op = Operator.ADD; }
    | '-' { $op = Operator.SUBTRACT; }
    | '*' { $op = Operator.MULTIPLY; }
    | '/' { $op = Operator.DIVIDE; }
    ;

array returns [Expression exp]
    :'convertible' {$exp = new ListExpression();}
    |i1 = INT 'to' i2 = INT {$exp = new ListExpression(Integer.parseInt($i1.text), Integer.parseInt($i2.text));}
    |{ArrayList<Expression> vals = new ArrayList<>();}
     '('a1 = literal{ vals.add($a1.exp); } (',' a2 = literal { vals.add($a2.exp); })*')' {$exp = new ListExpression(vals);}
    ;

comparison returns [Comparator cmp]
    : 'be' { $cmp = Comparator.EQUAL; }
    | 'more' 'than' { $cmp = Comparator.GREATER; }
    | 'less' 'than' { $cmp = Comparator.LESS; }
    ;

expression returns [Expression exp]
    : e1=expression op=operator e2=expression { $exp = new Arithmetic($op.op, $e1.exp, $e2.exp); }
    | e1=expression cmp=comparison e2=expression cap=bool { $exp = new Comparison($cmp.cmp, $e1.exp, $e2.exp, (BoolLiteral) $cap.exp); }
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
    | 'ima' 'hit' 'up' ID { $exp = new ExternalReference($ID.text); }
    | literal { $exp = $literal.exp; }
    | array { $exp = $array.exp; }
    | ID { $exp = new Dereference($ID.text); }
    | 'ima' 'turn' cn=('a'|'an') ID 'into' 'a' array {$exp = new Assignment($ID.text, $array.exp, $cn.text);}
    | 'ima' 'pop' INT 'from' ID {
       ArrayList<Expression> temp = new ArrayList<>();
       temp.add(new Dereference($ID.text));
       temp.add(new IntLiteral($INT.text));
       $exp = new Invocation("pop", temp);}
    | 'ima' 'add' literal 'to' ID {
       ArrayList<Expression> temp = new ArrayList<>();
       temp.add(new Dereference($ID.text));
       temp.add($literal.exp);
       $exp = new Invocation("Add", temp);}
    | 'ima' 'replace' INT 'with' literal 'in' ID {
       ArrayList<Expression> temp = new ArrayList<>();
       temp.add(new Dereference($ID.text));
       temp.add(new IntLiteral($INT.text));
       temp.add($literal.exp);
       $exp = new Invocation("Replace", temp);}
    | 'ima' 'get' INT 'from' ID {
       ArrayList<Expression> temp = new ArrayList<>();
       temp.add(new Dereference($ID.text));
       temp.add(new IntLiteral($INT.text));
       $exp = new Invocation("Get", temp);}
    ;

conditional returns [Expression exp]
    : { List<List<Expression>> bodys = new ArrayList<>(); List<Expression> conds = new ArrayList<>();}
      {List<Expression> exprs = new ArrayList<>();}
      'if' cnd=expression {conds.add($cnd.exp);}
      (statement { exprs.add($statement.exp); })*
      'yeah' {bodys.add(exprs);}
      ({List<Expression> exprs2 = new ArrayList<>();}
      'or' 'if' cnd2=expression {conds.add($cnd2.exp);}
      (statement { exprs2.add($statement.exp); })*
      'yeah' {bodys.add(exprs2);} )*
      {List<Expression> Or = new ArrayList<>();}
      ('or'
      (statement { Or.add($statement.exp); })*
      'yeah')?
      { $exp = new Conditional(conds, bodys, Or); }
    ;

loop returns [Expression exp]
    : { List<Expression> exprs = new ArrayList<>(); }
      'ima' 'do' 'this' 'rq'
      (e=expression { exprs.add($e.exp); })*
      'while' cnd=expression
      { $exp = new DoWhileLoop($cnd.exp, exprs); }
    | { List<Expression> exprs = new ArrayList<>(); }
      'while' cnd=expression
      (e=expression { exprs.add($e.exp); })*
      'yeah'
      { $exp = new WhileLoop($cnd.exp, exprs); }
    | { List<Expression> exprs = new ArrayList<>(); }
      'for' 'every' ID 'in' ls=expression
      (e=expression { exprs.add($e.exp); })*
      'yeah'
      { $exp = new ForLoop($ID.text, $ls.exp, exprs); }
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
INT : '-'?[0-9]+;
DOUBLE : '-'?[0-9]+ ('.' [0-9]+)?;
CHAR : '\'' [ -~] '\'';
STRING : '"' (~'"')+ '"';

// stuff that should be left on the very bottom
ID : [a-zA-Z_] [a-zA-Z0-9_]*;

COMMENT : ':)' ~'\n'* -> skip;
