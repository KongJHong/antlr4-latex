// Generated from E:/sources/antlr4-demo/src/main/java/expr\HongExprParser.g4 by ANTLR 4.9.1
package expr.conf;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HongExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HongExprParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HongExprParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(HongExprParser.EContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calc}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalc(HongExprParser.CalcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(HongExprParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(HongExprParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code secondary}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondary(HongExprParser.SecondaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(HongExprParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code package}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackage(HongExprParser.PackageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code param}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(HongExprParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calcLatex}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcLatex(HongExprParser.CalcLatexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code priority}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(HongExprParser.PriorityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fraction}
	 * labeled alternative in {@link HongExprParser#latex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraction(HongExprParser.FractionContext ctx);
}