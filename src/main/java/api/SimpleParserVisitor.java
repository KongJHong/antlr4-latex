// Generated from E:/sources/antlr4-demo/src/main/java/api\SimpleParser.g4 by ANTLR 4.9.1
package api;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(SimpleParser.SContext ctx);
}