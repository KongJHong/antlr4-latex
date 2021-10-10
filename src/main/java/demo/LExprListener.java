// Generated from E:/sources/antlr4-demo/src/main/java/demo\LExpr.g4 by ANTLR 4.9.1
package demo;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LExprParser}.
 */
public interface LExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link LExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(LExprParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link LExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(LExprParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LExprParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link LExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(LExprParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link LExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(LExprParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(LExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(LExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(LExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(LExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(LExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(LExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(LExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(LExprParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(LExprParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(LExprParser.IntContext ctx);
}