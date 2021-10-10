package api;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * Description     :
 */
public class TestSimple {
	public static void main(String[] args) throws IOException {
		CharStream input = new ANTLRFileStream(args[0]);
		SimpleLexer lexer = new SimpleLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SimpleParser parser = new SimpleParser(tokens);
		ParseTree t = parser.s();
		System.out.println(t.toStringTree(parser));
	}
}
