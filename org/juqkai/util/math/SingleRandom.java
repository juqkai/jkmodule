package org.juqkai.util.math;

import java.util.Random;

/**
 * 单例随机对象
 * @author juqkai(juqkai@gmail.com)
 */
public class SingleRandom {
	private Random ra = new Random();
	private static SingleRandom sr = new SingleRandom();
	private SingleRandom(){}
	
	public static Random makeRandom(){
		return sr.ra;
	}
	public static int nextInt(){
		return sr.ra.nextInt();
	}
	public static int nextInt(int n){
		return sr.ra.nextInt(n);
	}
	public static float nextFloat(){
		return sr.ra.nextFloat();
	}
	public static double nextDouble(){
		return sr.ra.nextDouble();
	}
	public static boolean nextBoolean(){
		return sr.ra.nextBoolean();
	}
	/**
	 * 返回一个-1 < n < 1 之间的浮点数
	 * @return
	 */
	public static double nextClamped(){
		return nextFloat() - nextFloat();
	}
}
