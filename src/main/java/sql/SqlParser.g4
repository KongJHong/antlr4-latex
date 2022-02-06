parser grammar SqlParser;

options {
    tokenVocab=SqlLexer;
    language=Java;
}

parse
    : select_stmt_list
    | error
    ;

select_stmt_list
    : ';'* select_stmt ( ';'+ select_stmt )* ';'*
    ;


error: input=~(SELECT|EXPLAIN)
{
  throw new RuntimeException($input.getText());
}
;

select_stmt: EXPLAIN? SELECT set_qualifier? element_clause from_clause? where_clause? group_by_clause? order_by_clause? limit_clause?;

set_qualifier:DISTINCT|ALL;
//--------------------------------elementClause------------------------------
element_clause: element (',' element)*;

element : '*'
        | table_name '.' '*'
        | expr
        ;

expr
        : literal_value    (AS? column_alias)?                                               # literalValue
        | ( ( database_name '.' )? table_name '.' )? column_name  (AS? column_alias)?        # columnName
        | unary_operator expr       (AS? column_alias)?                                      # unaryOperation // 一元运算符
        | expr operator=(ASSIGN|GT|GE|LT|LE|EQUAL|NOT_EQUAL) expr  (AS? column_alias)?       # binaryEqualOrAssign // 二元1类，比较&赋值
        | left=expr operator=(STAR|DIV|DIVIDE|MODULE) expr   (AS? column_alias)?             # binaryCalcPriority // 二元2类，运算  * / %
        | left=expr operator=(PLUS|MINUS) right=expr     (AS? column_alias)?                 # binaryCalcSecond // 二元2类  运算  + -
        | origin_function_name '(' (DISTINCT? expr (',' expr)* |STAR)?   ')'  (AS? column_alias)?   # originFunctionExpr   // ※方法  (系统自带/udf)
        | udf_function_name '(' (DISTINCT? expr (',' expr)* |STAR)?   ')'  (AS? column_alias)?   # udfFunctionExpr   // ※方法  (系统自带/udf)
        | '(' expr ')'             (AS? column_alias)?                                        # innerExpr
        | CAST '(' expr AS type_name ')'  (AS? column_alias)?                                # castExpr
        | expr IS NOT expr     (AS? column_alias)?                                           # isNotExpr
        | expr NOT? BETWEEN expr AND expr  (AS? column_alias)?                               # betweenExpr
        | expr NOT? IN ('('(select_stmt|expr(',' expr)*)?')'|(database_name DOT)? table_name)   (AS? column_alias)?  # inMethodExpr
        | (NOT? EXISTS)? '(' select_stmt ')'   (AS? column_alias)?                           # existsExpr
        | CASE expr? (WHEN expr THEN expr)+ (ELSE expr)? END   (AS? column_alias)?           # predicateExpr
        ;   // 各种expr


//--------------------------------fromClause------------------------------
from_clause: FROM table_reference (',' table_reference)*;

// table or subquery
table_reference
            : table_name table_alias_specification?
            | '('( (table_reference|select_stmt) (',' table_reference)*|joined_clause)*')' table_alias_specification?
            ;

table_alias_specification: AS? table_alias ('('column_name (',' column_name)*')')?;
joined_clause: table_reference (join_operator table_reference join_constraint)*;

join_operator:','| NATURAL? ((LEFT|FULL|RIGHT) (OUTER|INNER|CROSS)?)? JOIN;
join_constraint:(ON expr|USING '(' column_name (',' column_name)* ')');
//--------------------------------whereClause------------------------------
where_clause: WHERE expr;

//--------------------------------groupByClause------------------------------
group_by_clause: GROUP BY expr (',' expr)* (HAVING expr)?;

//--------------------------------orderByCluase------------------------------
order_by_clause: ORDER BY domain_name;

//--------------------------------limitClause------------------------------
limit_clause: LIMIT NUMERIC_LITERAL (',' NUMERIC_LITERAL)?;


unary_operator
 : MINUS
 | PLUS
 | NOT
 ;



column_alias:  IDENTIFIER | STRING_LITERAL;

domain_name: ((database_name '.')? table_name '.')? column_name;
table_name: (database_name '.')? any_name;
column_name: any_name;
database_name: any_name;
table_alias: any_name;


any_name
    : IDENTIFIER
    | STRING_LITERAL
    | '(' any_name ')'
    ;


// 字面意思的value
literal_value
     : NUMERIC_LITERAL
     | STRING_LITERAL
     | NULL
     | CURRENT_TIME
     | CURRENT_DATE
     | CURRENT_TIMESTAMP
     ;

// 类型名称     字段名|准确分类
type_name: domain_name|type_classify;
// 类型分类------------------------------------------------------
type_classify
            : character_string_type
            | bit_string_type
            | numeric_type
            | datetime_type
            ;
// （变长）字符串 类型
character_string_type: ((CHAR|CHARACTER) VARYING?|VARCHAR) ('(' length ')');
//  (变长)bit(length) 类型
bit_string_type : BIT VARYING? ('(' length ')')?;
// 数字类型
numeric_type: exact_numeric_type|approximate_numeric_type;
// 精确数字类型
exact_numeric_type: ((NUMERIC|DECIMAL|DEC)('(' precision (',' scala)? ')')?) |INTEGER|INT|SMALLINT;
// 非精确数字类型
approximate_numeric_type: FLOAT ('(' precision ')')?|REAL|DOUBLE PRECISION;
// 时间类型
datetime_type:DATE|(TIME ('(' time_precision ')')?|TIMESTAMP ('(' timestamp_precision ')')?) (WITH TIME ZONE)?;

length: NUMERIC_LITERAL;
precision: NUMERIC_LITERAL;
scala: NUMERIC_LITERAL;
time_precision: time_fractional_seconds_precision;
timestamp_precision : time_fractional_seconds_precision;
time_fractional_seconds_precision : NUMERIC_LITERAL;



// 增强------------------------------------------------------------

origin_function_name
            : ASCII
            | CHAR_LENGTH
            | CHARACTER_LENGTH
            | CONCAT
            | CONCAT_WS
            | FIELD
            | FIND_IN_SET
            | FORMAT
            | INSERT
            | LOCATE
            | LCASE
            | LEFT
            | LOWER
            | LPAD
            | LTRIM
            | MID
            | POSITION
            | REPEAT
            | REPLACE
            | REVERSE
            | RIGHT
            | RPAD
            | RTRIM
            | SPACE
            | STRCMP
            | SUBSTR
            | SUBSTRING
            | SUBSTRING_INDEX
            | TRIM
            | UCASE
            | UPPER
            // 数字函数
            | ABS
            | ACOS
            | ASIN
            | ATAN
            | ATAN2
            | AVG
            | CEIL
            | CEILING
            | COS
            | COT
            | COUNT
            | DEGREES
            | EXP
            | FLOOR
            | GREATEST
            | LEAST
            | LN
            | LOG
            | LOG10
            | LOG2
            | MAX
            | MIN
            | MOD
            | PI
            | POW
            | POWER
            | RADIANS
            | RAND
            | ROUND
            | SIGN
            | SIN
            | SQRT
            | SUM
            | TAN
            | TRUNCATE
            // 日期函数
            | ADDDATE
            | ADDTIME
            | CURDATE
            | CURRENT_DATE
            | CURRENT_TIME
            | CURRENT_TIMESTAMP
            | CURTIME
            | DATE
            | DATEDIFF
            | DATE_ADD
            | DATE_FORMAT
            | DATE_SUB
            | DAY
            | DAYNAME
            | DAYOFMONTH
            | DAYOFWEEK
            | DAYOFYEAR
            | EXTRACT
            | FROM_DAYS
            | HOUR
            | LAST_DAY
            | LOCALTIME
            | LOCALTIMESTAMP
            | MAKEDATE
            | MAKETIME
            | MICROSECOND
            | MINUTE
            | MONTHNAME
            | MONTH
            | NOW
            | PERIOD_ADD
            | PERIOD_DIFF
            | QUARTER
            | SECOND
            | SEC_TO_TIME
            | STR_TO_DATE
            | SUBDATE
            | SUBTIME
            | SYSDATE
            | TIME
            | TIME_FORMAT
            | TIME_TO_SEC
            | TIMEDIFF
            | TIMESTAMP
            | TIMESTAMPDIFF
            | TO_DAYS
            | WEEK
            | WEEKDAY
            | WEEKOFYEAR
            | YEAR
            | YEARWEEK
            ;

udf_function_name: any_name;