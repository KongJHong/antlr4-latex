package actions.tools;

import actions.tools.csv.CSVLexer;
import actions.tools.csv.CSVParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description     :
 */
@SuppressWarnings("all")
public class CSV {
	public static void main(String[] args) throws IOException {
		InputStream is = CSV.class.getClassLoader().getResourceAsStream("actions/users.csv");
		ANTLRInputStream input = new ANTLRInputStream(is);
		CSVLexer lexer = new CSVLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CSVParser parser = new CSVParser(tokens);

		parser.file();
	}
}
