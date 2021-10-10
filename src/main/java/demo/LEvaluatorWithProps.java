package demo;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Description     :
 */
public class LEvaluatorWithProps extends LExprBaseListener {

	ParseTreeProperty<Integer> values = new ParseTreeProperty<Integer>();

	@Override
	public void exitProg(LExprParser.ProgContext ctx) {
		super.exitProg(ctx);
	}

	@Override
	public void exitPrintExpr(LExprParser.PrintExprContext ctx) {
		super.exitPrintExpr(ctx);
	}

	@Override
	public void exitAssign(LExprParser.AssignContext ctx) {
		super.exitAssign(ctx);
	}

	@Override
	public void exitBlank(LExprParser.BlankContext ctx) {
		super.exitBlank(ctx);
	}

	@Override
	public void exitParens(LExprParser.ParensContext ctx) {
		super.exitParens(ctx);
	}

	@Override
	public void exitMulDiv(LExprParser.MulDivContext ctx) {
		super.exitMulDiv(ctx);
	}

	@Override
	public void exitAddSub(LExprParser.AddSubContext ctx) {
		super.exitAddSub(ctx);
	}

	@Override
	public void exitId(LExprParser.IdContext ctx) {
		super.exitId(ctx);
	}

	@Override
	public void exitInt(LExprParser.IntContext ctx) {
		super.exitInt(ctx);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		super.exitEveryRule(ctx);
	}

	public void setValue(ParseTree node, int value) {
		values.put(node, value);
	}

	public int getValue(ParseTree node) {
		return values.get(node);
	}
}
