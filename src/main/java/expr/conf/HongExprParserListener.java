// Generated from E:/sources/antlr4-demo/src/main/java/expr\HongExprParser.g4 by ANTLR 4.9.1
package expr.conf;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HongExprParser}.
 */
public interface HongExprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HongExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(HongExprParser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link HongExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(HongExprParser.EContext ctx);
	/**
	 * Enter a parse tree produced by the {@code calc}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterCalc(HongExprParser.CalcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calc}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitCalc(HongExprParser.CalcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(HongExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(HongExprParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(HongExprParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link HongExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(HongExprParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code secondary}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSecondary(HongExprParser.SecondaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code secondary}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSecondary(HongExprParser.SecondaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(HongExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(HongExprParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code package}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPackage(HongExprParser.PackageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code package}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPackage(HongExprParser.PackageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code param}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParam(HongExprParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code param}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParam(HongExprParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code calcLatex}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCalcLatex(HongExprParser.CalcLatexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calcLatex}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCalcLatex(HongExprParser.CalcLatexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code priority}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPriority(HongExprParser.PriorityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code priority}
	 * labeled alternative in {@link HongExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPriority(HongExprParser.PriorityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fraction}
	 * labeled alternative in {@link HongExprParser#latex}.
	 * @param ctx the parse tree
	 */
	void enterFraction(HongExprParser.FractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fraction}
	 * labeled alternative in {@link HongExprParser#latex}.
	 * @param ctx the parse tree
	 */
	void exitFraction(HongExprParser.FractionContext ctx);
}