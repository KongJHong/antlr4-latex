grammar Expr;

@header {
    package actions.tools.gens;
    import java.util.*;
}

// 嵌入到语法解析器中
@parser::members {
    /** "memory"字段用于存储变量/变量值对 */
    Map<String,Integer> memory = new HashMap<String,Integer>();

    int eval(int left,int op,int right){
        switch(op){
            case MUL: return left * right;
            case DIV: return left / right;
            case ADD: return left + right;
            case SUB: return left - right;
        }
        return 0;
    }
}

stat: e NEWLINE  {System.out.println($e.v);}
    | ID '=' e NEWLINE {memory.put($ID.text, $e.v);}
    | NEWLINE
    ;

e returns [int v]
    : a=e op=('*'|'/') b=e {$v = eval($a.v,$op.type,$b.v);}
    | a=e op=('+'|'-') b=e {$v = eval($a.v,$op.type,$b.v);}
    | INT {$v = $INT.int;}
    | ID
        {
            String id = $ID.text;
            $v = memory.containsKey(id)? memory.get(id):0;
        }
     | '(' e ')'    {$v=$e.v;}
     ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace