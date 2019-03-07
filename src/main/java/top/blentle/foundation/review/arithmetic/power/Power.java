package top.blentle.foundation.review.arithmetic.power;
/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/18 14:41
 * @mail: blentle.huan.ren@gmail.com
 * @description: 求一个数的n次幂
 * @since: 1.0
 */
public class Power {

	public static void main(String[] args) {
		System.err.println(0.00 == 0.0);
	}

	/**
	 *
	 * @param base 底数
	 * @param exponent 幂
	 * @return
	 */
	private double power(double base, int exponent) {
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		double result = power(base, exponent >> 1);
		result *= result;
		if((exponent & 1) == 1)
			result *= base;
		return result;
	}
}
