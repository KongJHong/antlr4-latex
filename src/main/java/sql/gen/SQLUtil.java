package sql.gen;

import org.antlr.v4.runtime.RuleContext;

import java.util.List;

/**
 * Description     :
 */
public class SQLUtil {

	private static class StandardizingListener extends SqlParserBaseVisitor<Boolean> {
		@Override
		public Boolean visitSqlInListExpr(SqlParser.SqlInListExprContext ctx) {
			List<SqlParser.SqlExprContext> targetList = ctx.sqlExpr();
			targetList.sort((a, b) -> {
				String aString = toSQLString(a);
				String bString = toSQLString(b);
				return aString.compareToIgnoreCase(bString);
			});
			return super.visitSqlInListExpr(ctx);
		}

		@Override
		public Boolean visitSqlBinaryOpExpr(SqlParser.SqlBinaryOpExprContext ctx) {
			if (ctx.operator.getType() == SqlParser.ADD ||
					ctx.operator.getType() == SqlParser.STAR ||
					ctx.operator.getType() == SqlParser.AND ||
					ctx.operator.getType() == SqlParser.OR) {
				// 1. 遍历右子节点
				ctx.left.accept(this);

				// 2.若右子节点有相同的运算符，将其旋转为根节点
				leftRotate(ctx);

				// 3.遍历左子节点
				ctx.right.accept(this);

				// 4. 对右子节点均为叶子节点的二叉树进行排序
                sort(ctx);

                return false;

			}

			return super.visitSqlBinaryOpExpr(ctx);
		}

		@Override
		public Boolean visitSqlAggregateExpr(SqlParser.SqlAggregateExprContext ctx) {
			List<SqlParser.ArgumentsContext> arguments = ctx.arguments();
			arguments.sort((a,b)->{
				String aString = toSQLString(a);
				String bString = toSQLString(b);
				return aString.compareToIgnoreCase(bString);
			});

			return super.visitSqlAggregateExpr(ctx);
		}

		private void leftRotate(RuleContext ctx) {

		}

		private void sort(SqlParser.SqlBinaryOpExprContext ctx) {

		}

		private String toSQLString(RuleContext ctx) {
			return ctx.getText();
		}
	}
}
