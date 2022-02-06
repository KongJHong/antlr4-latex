grammar HongExprParser;

e: expr;
expr
    : expr op=(MUL|DIV) expr
    | expr op=(ADD|SUB) expr
    | KW_LB expr KW_RB
    | PARAM
    ;

MUL: '*';
ADD: '+';
DIV: '/';
SUB: '-';
KW_LB: '(';
KW_RB: ')';
NEWLINE: '\r'? '\n';
WS: [ \t\n] -> skip;
PARAM:ID DIGIT*;
fragment ID: [a-zA-Z]+;
fragment DIGIT: '0'..'9';