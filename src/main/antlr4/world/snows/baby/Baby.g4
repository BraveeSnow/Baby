grammar Baby;

@header {
import world.snows.baby.expression.*;
}

program returns [Expression exp]
    : 'LESS GOOO\n'
      'YEAH YEAH\n'
      EOF { $exp = new IntLiteral("1"); }
    ;

WS : [ \r\n\t] -> skip;
