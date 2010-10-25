package org.juqkai.util;

public class Point {
	private double x;
	private double y;
	public Point(){}
	public Point(double x, double y){
		this.x = x ;
		this.y = y ;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * 乘以另外一个向量
	 * @param value 乘数
	 * @return
	 */
	public Point multiplication(double value){
		return new Point(x * value, y * value);
	}
	
	public Point add(Point value){
		return new Point(x + value.x, y + value.y);
	}
	/**
	 * 减去另外一个向量
	 * @param value
	 * @return
	 */
	public Point subtraction(Point value){
		return new Point(x - value.x, y - value.y);
	}
	/**
	 * 规范化向量,即将向量的值调整成1
	 * @param wine
	 * @return
	 */
	public Point normalise() {
		Point nor = new Point();
		nor.setX(x / length());
		nor.setY(y / length());
		return nor;
	}
	/**
	 * 计算向量的长度
	 * @return
	 */
	public double length() {
		return Math.sqrt(x * x + y * y);
	}
	
	/**
	 * 计算点积
	 * @param value
	 * @return
	 */
	public double dotProduct(Point value){
		return x * value.x + y * value.y;
	}
	/**
	 * 计算点积
	 * @param value
	 * @return
	 */
	public double dotProduct(Point value, Point value2){
		return value.dotProduct(value2);
	}
	
	/**
	 * 计算参数是在左边还是在右边
	 * @param v1
	 * @return 
	 * <ul>
	 * <li>大于1,即V1在左边
	 * <li>小于1,即V1在右边
	 * </ul>
	 */
	public int positive(Point v1){
		if(y * v1.y > x * v1.y){
			return 1;
		}
		return -1;
	}
	/**
	 * 计算参数是在左边还是在右边
	 * @param v1 参考点
	 * @param v2 目标点
	 * @return 
	 * <ul>
	 * <li>大于1,即V1在左边
	 * <li>小于1,即V1在右边
	 * </ul>
	 */
	public int positive(Point v1, Point v2){
		return v1.positive(v2);
	}
	
	@Override
	public String toString() {
		return "x:" + x + "\ty:" + y;
	}
}
