parser grammar HongExprParser;

options{
    tokenVocab=HongExprLexer;
}

e: stat+;

stat: expr NEWLINE              # calc
    | PARAM KW_EQ expr NEWLINE  # assign
    | NEWLINE                   # blank
    ;

expr
    : expr op=(MUL|DIV) expr    # priority
    | expr op=(ADD|SUB) expr    # secondary
    | latex                     # calcLatex
    | NUMBER                    # number
    | PARAM                     # param
    | KW_LB expr KW_RB          # package
    ;

latex
    : KW_FRACTION KW_LBRACE expr KW_RBRACE KW_LBRACE expr KW_RBRACE  # fraction
    ;