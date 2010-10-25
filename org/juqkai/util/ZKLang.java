package org.juqkai.util;

public class ZKLang {
	/**
	 * 检测空对象
	 * @param obj
	 * @return true:空对象,false:非空
	 * @author juqkai(juqkai@gmail.com) 2010-10-12
	 */
	public static boolean isNull(Object obj){
		return obj == null;
	}
	/**
	 * 检测非空
	 * @param obj
	 * @return true:非空,false:空
	 * @author juqkai(juqkai@gmail.com) 2010-10-12
	 */
	public static boolean isNotNull(Object obj){
		return !isNull(obj);
	}
}
