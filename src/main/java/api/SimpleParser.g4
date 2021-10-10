parser grammar SimpleParser;

options{
    // 从SimpleLexer.tokens获取词法符号类型
    // 不要将它命名为SimpleParser.tokens,因为ANTLR会覆盖它
    tokenVocab=SimpleLexer;
}

s: (ID|INT)*SEMI;