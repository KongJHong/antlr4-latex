lexer grammar SqlLexer;



SINGLE_LINE_COMMENT: '--' ~[\r\n]* -> channel(HIDDEN);

MULTILINE_COMMENT: '/*' .*? ( '*/' | EOF ) -> channel(HIDDEN);

SPACES: [ \u000B\t\r\n] -> channel(HIDDEN);



// Keyword 关键词
ALL:                            A L L;
AND:                            A N D;
AS:                             A S;
BETWEEN:                        B E T W E E N;
BIT:                            B I T;
BY:                             B Y;
CASE:                           C A S E;
CAST:                           C A S T;
CHAR:                           C H A R;
CHARACTER:                      C H A R A C T E R;
CROSS:                          C R O S S;
DEC:                            D E C;
DECIMAL:                        D E C I M A L;
DISTINCT:                       D I S T I N C T;
DOUBLE:                         D O U B L E;
ELSE:                           E L S E;
END:                            E N D;
EXISTS:                         E X I S T S;
EXPLAIN:                        E X P L A I N;
FROM:                           F R O M;
FULL:                           F U L L;
FLOAT:                          F L O A T;
HAVING:                         H A V I N G;
JOIN:                           J O I N;
IN:                             I N;
INNER:                          I N N E R;
INT:                            I N T;
INTEGER:                        I N T E G E R;
IS:                             I S;
LIMIT:                          L I M I T;
NATURAL:                        N A T U R A L;
NULL:                           N U L L;
NOT:                            N O T;
NUMERIC:                        N U M E R I C;
GROUP:                          G R O U P;
ON:                             O N;
OR:                             O R;
ORDER:                          O R D E R;
OUTER:                          O U T E R;
PRECISION:                      P R E C I S I O N;
REAL:                           R E A L;
SELECT:                         S E L E C T;
SMALLINT:                       S M A L L I N T;
THEN:                           T H E N;
USING:                          U S I N G;
VARCHAR:                        V A R C H A R;
VARYING:                        V A R Y I N G;
WHEN:                           W H E N;
WHERE:                          W H E R E;
WITH:                           W I T H;
ZONE:                           Z O N E;



// Operators. Arithmetics
STAR:                                '*';
DIVIDE:                              '/';
MODULE:                              '%';
PLUS:                                '+';
MINUSMINUS:                          '--';
MINUS:                               '-';
DIV:                                 'DIV';
GT:                                  '>';
LT:                                  '<';
GE:                                  '>=';
LE:                                  '<=';
EQUAL:                               '==';
NOT_EQUAL:                           '!='|'<>';
ASSIGN:                              '=';

// BIT Operators
BIT_OR:                              '||';

// 字符串函数--------------------------------------------------------------------
ASCII:                              A S C I I;
CHAR_LENGTH:                        C H A R '_' L E N G T H;
CHARACTER_LENGTH:                   C H A R A C T E R '_' L E N G T H;
CONCAT:                             C O N C A T;
CONCAT_WS:                          C O N C A T '_' W S;
FIELD:                              F I E L D;
FIND_IN_SET:                        F I N D '_' I N '_' S E T;
FORMAT:                             F O R M A T;
INSERT:                             I N S E R T;
LOCATE:                             L O C A T E;
LCASE:                              L C A S E;
LEFT:                               L E F T;
LOWER:                              L O W E R;
LPAD:                               L P A D;
LTRIM:                              L T R I M;
MID:                                M I D;
POSITION:                           P O S I T I O N;
REPEAT:                             R E P E A T;
REPLACE:                            R E P L A C E;
REVERSE:                            R E V E R S E;
RIGHT:                              R I G H T;
RPAD:                               R P A D;
RTRIM:                              R T R I M;
SPACE:                              S P A C E;
STRCMP:                             S T R C M P;
SUBSTR:                             S U B S T R;
SUBSTRING:                          S U B S T R I N G;
SUBSTRING_INDEX:                    S U B S T R I N G '_' I N D E X;
TRIM:                               T R I M;
UCASE:                              U C A S E;
UPPER:                              U P P E R;

//数字相关函数----------------------------------------------------
ABS:                                    A B S;
ACOS:                                   A C O S;
ASIN:                                   A S I N;
ATAN:                                   A T A N;
ATAN2:                                  A T A N TWO_DECIMAL;
AVG:                                    A V G;
CEIL:                                   C E I L;
CEILING:                                C E I L I N G;
COS:                                    C O S;
COT:                                    C O T;
COUNT:                                  C O U N T;
DEGREES:                                D E G R E E S;
EXP:                                    E X P;
FLOOR:                                  F L O O R;
GREATEST:                               G R E A T E S T;
LEAST:                                  L E A S T;
LN:                                     L N;
LOG:                                    L O G;
LOG10:                                  L O G TEN_DECIMAL;
LOG2:                                   L O G TWO_DECIMAL;
MAX:                                    M A X;
MIN:                                    M I N;
MOD:                                    M O D;
PI:                                     P I;
POW:                                    P O W;
POWER:                                  P O W E R;
RADIANS:                                R A D I A N S;
RAND:                                   R A N D;
ROUND:                                  R O U N D;
SIGN:                                   S I G N;
SIN:                                    S I N;
SQRT:                                   S Q R T;
SUM:                                    S U M;
TAN:                                    T A N;
TRUNCATE:                               T R U N C A T E;

//日期相关函数----------------------------------------------------
ADDDATE:                                A D D D A T E;
ADDTIME:                                A D D T I M E;
CURDATE:                                C U R D A T E;
CURRENT_DATE:                           C U R R E N T '_' D A T E;
CURRENT_TIME:                           C U R R E N T '_' T I M E;
CURRENT_TIMESTAMP:                      C U R R E N T '_' T I M E S T A M P;
CURTIME:                                C U R T I M E ;
DATE:                                   D A T E;
DATEDIFF:                               D A T E D I F F;
DATE_ADD:                               D A T E '_' A D D;
DATE_FORMAT:                            D A T E '_' F O R M A T;
DATE_SUB:                               D A T E '_' S U B;
DAY:                                    D A Y;
DAYNAME:                                D A Y N A M E;
DAYOFMONTH:                             D A Y O F M O N T H;
DAYOFWEEK:                              D A Y O F W E E K;
DAYOFYEAR:                              D A Y O F Y E A R;
EXTRACT:                                E X T R A C T;
FROM_DAYS:                              F R O M '_' D A Y S;
HOUR:                                   H O U R;
LAST_DAY:                               L A S T '_' D A Y;
LOCALTIME:                              L O C A L T I M E;
LOCALTIMESTAMP:                         L O C A L T I M E S T A M P;
MAKEDATE:                               M A K E D A T E;
MAKETIME:                               M A K E T I M E;
MICROSECOND:                            M I C R O S E C O N D;
MINUTE:                                 M I N U T E;
MONTHNAME:                              M O N T H N A M E;
MONTH:                                  M O N T H;
NOW:                                    N O W;
PERIOD_ADD:                              P E R I O D '_' A D D;
PERIOD_DIFF:                            P E R I O D '_' D I F F;
QUARTER:                                Q U A R T E R;
SECOND:                                 S E C O N D;
SEC_TO_TIME:                            S E C '_' T O  '_' T I M E ;
STR_TO_DATE:                            S T R '_' T O '_' D A T E;
SUBDATE:                                S U B D A T E;
SUBTIME:                                S U B T I M E;
SYSDATE:                                S Y S D A T E;
TIME:                                   T I M E;
TIME_FORMAT:                            T I M E '_' F O R M A T;
TIME_TO_SEC:                            T I M E '_' T O '_' S E C;
TIMEDIFF:                               T I M E D I F F;
TIMESTAMP:                              T I M E S T A M P;
TIMESTAMPDIFF:                          T I M E S T A M P D I F F;
TO_DAYS:                                T O '_' D A Y S;
WEEK:                                   W E E K;
WEEKDAY:                                W E E K D A Y;
WEEKOFYEAR:                             W E E K O F Y E A R;
YEAR:                                   Y E A R;
YEARWEEK:                               Y E A R W E E K;


// ID
IDENTIFIER
 : '"' (~'"' | '""')* '"'
 | '`' (~'`' | '``')* '`'
 | '[' ~']'* ']'
 | [a-zA-Z_] [a-zA-Z_0-9]* // TODO check: needs more chars in set
 ;

STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;

// 数字常规映射----------------------------------------
//UNSIGNED_INTEGER: DIGIT+;   // 正整数（不含+）

NUMERIC_LITERAL
        : (DIGIT+)? '.' DIGIT+      // 匹配 1.12 或.12
        | DIGIT+ '.' EXPONENET_NUM_PART // 匹配 1.12E+10
       | (DIGIT+)? '.' (DIGIT+ EXPONENET_NUM_PART) // 匹配 .12E+10
        | DIGIT+ (EXPONENET_NUM_PART)? // 匹配12(E-10)? 整数或E
        ;

// 数字
fragment EXPONENET_NUM_PART: E [-+]? DIGIT+;  // e+10 e-10 ...
fragment DIGIT: [0-9];

// 符号集------------------------------------------------
DOT :                                '.';
LR_BRACKET:                          '(';
RR_BRACKET:                          ')';
COMMA:                               ',';
SEMI:                                ';';
AT_SIGN:                             '@';
ZERO_DECIMAL:                        '0';
ONE_DECIMAL:                         '1';
TWO_DECIMAL:                         '2';
TEN_DECIMAL:                         '10';
SINGLE_QUOTE_SYMB:                   '\'';
DOUBLE_QUOTE_SYMB:                   '"';
REVERSE_QUOTE_SYMB:                  '`';
COLON_SYMB:                          ':';


// alphabet  字母表---------------------------------------------
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];