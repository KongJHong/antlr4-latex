package expr;

import expr.conf.HongExprParser;
import expr.conf.HongExprParserBaseListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import utils.BigDecimalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description     :
 */
public class HongExprEvaluatorListener extends HongExprParserBaseListener {

	ParseTreeProperty<BigDecimalUtil> memory = new ParseTreeProperty<>();
	Map<String, Double> paramMap = new HashMap<>();
	List<BigDecimalUtil> results = new ArrayList<>();

	@Override
	public void exitE(HongExprParser.EContext ctx) {
		for (HongExprParser.StatContext statContext : ctx.stat()) {
			results.add(getValue(statContext).setScala(2));
		}
	}

	@Override
	public void exitCalc(HongExprParser.CalcContext ctx) {
		System.out.println("exitCalc:" + ctx.expr().getText());
		setValue(ctx, getValue(ctx.expr()));
	}

	@Override
	public void exitAssign(HongExprParser.AssignContext ctx) {
		System.out.println("exitAssign:" + ctx.expr().getText());
		paramMap.put(ctx.PARAM().getText(), Double.valueOf(ctx.expr().getText()));
		setValue(ctx, getValue(ctx.expr()));
	}

	@Override
	public void exitBlank(HongExprParser.BlankContext ctx) {
		System.out.println("exitBlank:" + "白板");
	}

	@Override
	public void exitSecondary(HongExprParser.SecondaryContext ctx) {
		BigDecimalUtil left = getValue(ctx.expr(0));
		BigDecimalUtil right = getValue(ctx.expr(1));
		if (ctx.op.getType() == HongExprParser.ADD) {
			setValue(ctx, left.add(right));
		} else {
			setValue(ctx, left.sub(right));
		}
	}

	@Override
	public void exitNumber(HongExprParser.NumberContext ctx) {
		System.out.println("exitNumber:" + ctx.NUMBER().getText());
		setValue(ctx, BigDecimalUtil.of(ctx.NUMBER().getText()));
	}

	@Override
	public void exitPackage(HongExprParser.PackageContext ctx) {
		System.out.println("exitPackage:" + ctx.expr().getText());
		setValue(ctx, getValue(ctx.expr()));
	}

	@Override
	public void exitPriority(HongExprParser.PriorityContext ctx) {
		BigDecimalUtil left = getValue(ctx.expr(0));
		BigDecimalUtil right = getValue(ctx.expr(1));
		if (ctx.op.getType() == HongExprParser.MUL) {
			setValue(ctx, left.mul(right));
		} else {
			setValue(ctx, left.divide(right));
		}
	}

	@Override
	public void exitCalcLatex(HongExprParser.CalcLatexContext ctx) {
		setValue(ctx, getValue(ctx.latex()));
	}

	@Override
	public void exitFraction(HongExprParser.FractionContext ctx) {
		BigDecimalUtil upper = getValue(ctx.expr(0));
		BigDecimalUtil under = getValue(ctx.expr(1));
		setValue(ctx, upper.divide(under));
	}

	public BigDecimalUtil getValue(ParseTree node) {
		BigDecimalUtil result = memory.get(node);
		if (result == null)result = BigDecimalUtil.of(paramMap.getOrDefault(node.getText(),0D));
		return result;
	}

	public void setValue(ParseTree node, BigDecimalUtil value) {
		memory.put(node, value);
	}

	public List<BigDecimalUtil> getResults() {
		return results;
	}

}

