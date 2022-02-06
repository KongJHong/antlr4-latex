package sql;

import sql.gen.SqlParser;
import sql.gen.SqlParserBaseListener;

public class SqlListener extends SqlParserBaseListener {


	// 这里应该是一个Map<接口,List(字段名)>   或者一个N元组

	// TODO 下推自动机


	@Override
	public void enterUdfFunctionExpr(SqlParser.UdfFunctionExprContext ctx) {
		if (ctx.STAR() == null) {
			System.out.println("func name: " + ctx.udf_function_name().getText());
			System.out.print("expr:\t");
			for (SqlParser.ExprContext expr : ctx.expr()) {
				System.out.print(expr.getText() + "\t");
			}
		}
		System.out.println();
	}




}