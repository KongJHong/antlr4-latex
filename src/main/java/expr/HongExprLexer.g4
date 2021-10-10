lexer grammar HongExprLexer;

MUL: '*';
ADD: '+';
DIV: '/' | '\\div';
SUB: '-';

NEWLINE: '\r'? '\n';
WS: [ \t\n] -> skip;
//PARAM: '${' ID DIGIT* '}';
PARAM:ID DIGIT*;
fragment
ID: [a-zA-Z]+;

NUMBER: '-' ? ('.' DIGIT+ | DIGIT+ ('.' DIGIT*)?);
fragment
DIGIT: '0'..'9';


KW_FRACTION: '\\frac';
KW_LBRACE: '{';
KW_RBRACE: '}';
KW_EQ: '=';
KW_LB: '(';
KW_RB: ')';