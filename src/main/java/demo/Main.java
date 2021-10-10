package demo;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description     :
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputStream is = Main.class.getClassLoader().getResourceAsStream("expr/t.txt");
		ANTLRInputStream input = new ANTLRInputStream(is);
		LExprLexer lexer = new LExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LExprParser parser = new LExprParser(tokens);


		ParseTree parseTree = parser.prog();
		LEvaluatorWithProps listener = new LEvaluatorWithProps();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, parseTree);
		System.out.println(listener.getValue(parseTree));
	}
}
