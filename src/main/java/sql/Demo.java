package sql;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import sql.gen.SqlLexer;
import sql.gen.SqlParser;

/**
 * Description     :
 */
public class Demo {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		String sql = "select udfA(a-udfB(b)) from t_a;";
		ANTLRInputStream input = new ANTLRInputStream(sql);
		SqlLexer lexer = new SqlLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SqlParser parser = new SqlParser(tokens);
		ParseTree tree = parser.parse();
		ParseTreeWalker walker = new ParseTreeWalker();
		SqlListener listener = new SqlListener();
		walker.walk(listener, tree);


	}
}
