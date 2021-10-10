package actions.tools;

import actions.tools.gens.ExprLexer;
import actions.tools.gens.ExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

/**
 * Description     :
 */
@SuppressWarnings("all")
public class Calc {
	public static void main(String[] args) throws IOException {
		String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String expr = br.readLine();              // get first expression
        int line = 1;                             // track input expr line numbers

		ExprParser parser = new ExprParser(null); // share single parser instance
  		parser.setBuildParseTree(false);          // don't need trees

        while ( expr!=null ) {             // while we have more expressions
            // create new lexer and token stream for each line (expression)
            ANTLRInputStream input = new ANTLRInputStream(expr+"\n");
            ExprLexer lexer = new ExprLexer(input);
            lexer.setLine(line);           // notify lexer of input position
            lexer.setCharPositionInLine(0);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser.setInputStream(tokens); // notify parser of new token stream
            parser.stat();                 // start the parser
            expr = br.readLine();          // see if there's another line
            line++;
        }
	}
}
