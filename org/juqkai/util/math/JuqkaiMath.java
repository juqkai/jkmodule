package org.juqkai.util.math;

/**
 * juqkai数学函数
 * @author juqkai(juqkai@gmail.com) 2010-6-13
 */
public class JuqkaiMath {
	/**
	 * 将value转换到固定范围内
	 * @param value 需要转换的值
	 * @param min 最小值
	 * @param max 最大值
	 * @return 
	 * <ul>
	 * <li> value > max 返回 max
	 * <li> value < min 返回min
	 * <li> 以上两个都不满足,直接返回value
	 * </ul>
	 */
	public static Double clamp(double value, double min, Double max) {
		if(value < min){
			return min;
		}
		if(value > max){
			return max;
		}
		return value;
	}
}
