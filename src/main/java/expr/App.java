package expr;


import actions.tools.gens.ExprLexer;
import expr.conf.HongExprLexer;
import expr.conf.HongExprParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Description     :
 */
public class App {
	public static void main(String[] args) throws IOException {
		InputStream is = App.class.getClassLoader().getResourceAsStream("expr/t.txt");

//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//		HongExprParser parser = new HongExprParser(null);
//
//		HongExprEvaluatorListener listener = new HongExprEvaluatorListener();
//		ParseTreeWalker walker = new ParseTreeWalker();
//
//		String expr = br.readLine();
//		int line = 1;
//		while (StringUtils.isNotEmpty(expr)) {
//			CharStream input = CharStreams.fromString(expr + "\n");
//			ExprLexer lexer = new ExprLexer(input);
//			lexer.setLine(line++);
//			lexer.setCharPositionInLine(0);
//
//			CommonTokenStream tokens = new CommonTokenStream(lexer);
//			parser.setInputStream(tokens);
//			ParseTree parseTree = parser.e();
//
//			walker.walk(listener, parseTree);
//			System.out.println(listener.getValue(parseTree));
//			expr = br.readLine();
//		}

		CharStream input = CharStreams.fromStream(is);
		HongExprLexer lexer = new HongExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HongExprParser parser = new HongExprParser(tokens);

		ParseTree parseTree = parser.e();
		HongExprEvaluatorListener listener = new HongExprEvaluatorListener();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, parseTree);
		System.out.println(listener.getResults());


	}
}
