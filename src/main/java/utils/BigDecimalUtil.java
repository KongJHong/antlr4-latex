package utils;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author KongJHong
 * date 2021/8/23
 * description: big decimal 工具类
 * 兼容性扩展为Number类型
 */
@Getter
@Setter
@SuppressWarnings("all")
@Accessors(chain = true)
public class BigDecimalUtil extends Number implements Comparable<BigDecimalUtil> {

	private BigDecimal bigDecimal;

	/**
	 * 默认精度为12
	 */
	private int scala;

	/**
	 * 默认舍入模式为 BigDecimal.ROUND_CEILING
	 */
	private int roundingMode;

	/**
	 * 屏蔽默认构造函数
	 */
	private BigDecimalUtil() {
	}

	public static BigDecimalUtil copy(BigDecimalUtil oth) {
		return BigDecimalUtil.of(oth.getBigDecimal().doubleValue(), oth.getScala(), oth.getRoundingMode());
	}

	/**
	 * 提高兼容性
	 */
	public static <T extends Number> BigDecimalUtil of(T decimal) {
		return of(decimal, 12, BigDecimal.ROUND_CEILING);
	}

	public static <T extends Number> BigDecimalUtil of(T decimal, Integer scala) {
		return of(decimal, scala, BigDecimal.ROUND_CEILING);
	}

	public static BigDecimalUtil of(CharSequence decimal) {
		return of(new BigDecimal(decimal.toString()), 12, BigDecimal.ROUND_CEILING);
	}

	public static <T extends Number> BigDecimalUtil of(T decimal, Integer scala, Integer roundingMode) {
		BigDecimalUtil util = new BigDecimalUtil();
		util.setRoundingMode(roundingMode);
		util.setBigDecimal(BigDecimal.valueOf(decimal.doubleValue()));
		util.setScala(scala);
		return util;
	}

	public static BigDecimalUtil ofZero() {
		return ofZero(12, BigDecimal.ROUND_CEILING);
	}

	public static BigDecimalUtil ofZero(Integer scala) {
		return ofZero(scala, BigDecimal.ROUND_CEILING);
	}

	public static BigDecimalUtil ofZero(Integer scala, Integer roundingMode) {
		return of(0D, scala, roundingMode);
	}

	public <T extends Number> BigDecimalUtil add(T value) {
		BigDecimal decimal = BigDecimal.valueOf(value.doubleValue());
		this.bigDecimal = this.bigDecimal.add(decimal);
		return this;
	}

	public <T extends Number> BigDecimalUtil sub(T value) {
		BigDecimal decimal = BigDecimal.valueOf(value.doubleValue());
		this.bigDecimal = this.bigDecimal.subtract(decimal);
		return this;
	}

	public <T extends Number> BigDecimalUtil mul(T value) {
		BigDecimal decimal = BigDecimal.valueOf(value.doubleValue());
		this.bigDecimal = this.bigDecimal.multiply(decimal);
		return this;
	}

	/**
	 * 默认四舍五入方式为 RoundingMode.DOWN
	 */
	public <T extends Number> BigDecimalUtil divide(T value) {
		return divide(value, RoundingMode.DOWN);
	}

	public <T extends Number> BigDecimalUtil divide(T value, RoundingMode round) {
		if (Double.compare(value.doubleValue(), 0d) == 0) throw new ArithmeticException("/ by zero, value:" + value);
		BigDecimal decimal = BigDecimal.valueOf(value.doubleValue());
		this.bigDecimal = this.bigDecimal.divide(decimal, this.scala, round);
		return this;
	}

	/**
	 * 安全除法：<br>
	 * 如果value == 0,不除，直接返回
	 *
	 * @param value double
	 */
	public <T extends Number> BigDecimalUtil divideInSafe(T value) {
		if (Double.compare(value.doubleValue(), 0d) == 0) return this;
		return divide(value);
	}

	public BigDecimal toDecimal() {
		return this.bigDecimal.setScale(this.scala, this.roundingMode);
	}

	public BigDecimal toPureDecimal() {
		return this.bigDecimal;
	}

	/**
	 * 返回plain string,即非科学统计法的类型
	 */
	public String toPlainString() {
		return toPlainString(this.scala);
	}

	public String toPlainString(int tScala) {
		return toPlainString(tScala, this.roundingMode);
	}

	public String toPlainString(int tScala, int tRoundingMode) {
		return this.bigDecimal.setScale(tScala, tRoundingMode).toPlainString();
	}

	public String toString() {
		return this.bigDecimal.setScale(this.scala, this.roundingMode).toString();
	}

	/**
	 * 设置数字为0，精度，舍入模式不变
	 */
	public void clear() {
		this.bigDecimal = BigDecimal.ZERO;
	}

	/**
	 * 设置数字为0，精度，舍入模式不变
	 */
	public void reset() {
		this.clear();
	}

	public boolean gt(BigDecimalUtil oth) {
		return this.bigDecimal.compareTo(oth.getBigDecimal()) > 0;
	}

	public boolean lt(BigDecimalUtil oth) {
		return this.bigDecimal.compareTo(oth.getBigDecimal()) < 0;
	}

	public boolean ge(BigDecimalUtil oth) {
		return this.bigDecimal.compareTo(oth.getBigDecimal()) >= 0;
	}

	public boolean ge(BigDecimal oth) {
		return this.bigDecimal.compareTo(oth) >= 0;
	}

	public boolean le(BigDecimalUtil oth) {
		return this.bigDecimal.compareTo(oth.getBigDecimal()) <= 0;
	}

	public boolean eq(BigDecimalUtil oth) {
		return this.bigDecimal.compareTo(oth.getBigDecimal()) == 0;
	}

	@Override
	public int compareTo(BigDecimalUtil oth) {
		return this.bigDecimal.compareTo(oth.getBigDecimal());
	}

	@Override
	public int intValue() {
		return this.bigDecimal.setScale(this.scala, this.roundingMode).intValue();
	}

	@Override
	public long longValue() {
		return this.bigDecimal.setScale(this.scala, this.roundingMode).longValue();
	}

	@Override
	public float floatValue() {
		return this.bigDecimal.setScale(this.scala, this.roundingMode).floatValue();
	}

	@Override
	public double doubleValue() {
		return this.bigDecimal.setScale(this.scala, this.roundingMode).doubleValue();
	}


	public static void main(String[] args) {
		BigDecimalUtil util = BigDecimalUtil.ofZero();
		// (0+2.22)/2*100
		util.add(2.22222d).divide(2, RoundingMode.FLOOR).mul(100D);
		System.out.println(util.toPlainString(2, BigDecimal.ROUND_DOWN));

		BigDecimal decimal = util.toDecimal();
		decimal = decimal.add(BigDecimal.ONE);
		System.out.println(decimal.toPlainString());

	}
}


