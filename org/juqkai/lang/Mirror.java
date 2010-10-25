package org.juqkai.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.juqkai.util.string.Strings;
/**
 * 仿照 nute 框架,包裹了 Class<?>
 * 提供了更多的反射方法
 * @author juqkai(juqkai@gmail.com) 2010-10-25
 */
public class Mirror <T> {
	Class<T> zlass;
	public Class<T> getType() {
		return zlass;
	}
	
	public Mirror(Class<T> classType){
		zlass = classType;
	}
	public static <T> Mirror<T> me(Class<T> class1) {
		return class1 == null ? null : new Mirror<T>(class1);
	}
	public boolean isEnum() {
		return zlass.isEnum();
	}
	/**
	 * 获取所有非静态,唯一字段
	 * @return
	 * @author juqkai(juqkai@gmail.com) 2010-10-25
	 */
	public Field[] getFields(){
		Class<?> cc = zlass;
		Map<String, Field> map = new HashMap<String, Field>();
		while(cc != null && cc != Object.class){
			for(Field fi : cc.getDeclaredFields()){
				if(isIgnoredField(fi))
					continue;
				if(!map.containsKey(fi.getName())){
					map.put(fi.getName(), fi);
				}
			}
			cc = cc.getSuperclass();
		}
		return map.values().toArray(new Field[map.size()]);
	}
	/**
	 * 是否忽略字段
	 * @param f
	 * @return
	 * @author juqkai(juqkai@gmail.com) 2010-10-25
	 */
	private static boolean isIgnoredField(Field f) {
		return Modifier.isStatic(f.getModifiers())
				|| Modifier.isFinal(f.getModifiers())
				|| f.getName().startsWith("this$");
	}
	/**
	 * 获取字段的值
	 * @param obj
	 * @param fi
	 * @return
	 * @author juqkai(juqkai@gmail.com) 2010-10-25
	 */
	public Object getValue(Object obj, Field fi) {
		if(fi.isAccessible()){
			fi.setAccessible(true);
		}
		try {
			return fi.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(obj.getClass()+" " + fi.getName());
		}
	}
	/**
	 * 获取字段的值
	 * @param obj
	 * @param name
	 * @return
	 * @author juqkai(juqkai@gmail.com) 2010-10-25
	 */
	public Object getValue(Object obj, String name){
		try {
			return getGetter(name).invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				return getValue(obj, getField(name));
			} catch (NoSuchFieldException e1) {
				throw new IllegalArgumentException(obj.getClass()+" " + name);
			}
		}
	}
	/**
	 * 获取字段
	 * @param name
	 * @return
	 * @throws NoSuchFieldException
	 * @author juqkai(juqkai@gmail.com) 2010-10-25
	 */
	private Field getField(String name) throws NoSuchFieldException {
		Class<?> cc = zlass;
		while(cc != null && cc != Object.class){
			try {
				return cc.getField(name);
			} catch (Exception e) {
				cc = cc.getSuperclass();
			}
		}
		throw new NoSuchFieldException("");
	}
	/**
	 * 获取 get 方法
	 * @param name
	 * @return
	 * @throws NoSuchMethodException
	 * @author juqkai(juqkai@gmail.com) 2010-10-25
	 */
	public Method getGetter(String name) throws NoSuchMethodException{
		String fn = Strings.capitalize(name);
		try{
			try{
				return zlass.getMethod("get" + fn);
			} catch (NoSuchMethodException e){
				Method m = zlass.getMethod("is" + fn);
				if (!Mirror.me(m.getReturnType()).isBoolean())
					throw new NoSuchMethodException();
				return m;
			}
		}catch (NoSuchMethodException e){
			throw new NoSuchMethodException("field \"" + name + "\" no such getter method!");
		}
	}
	/**
	 * 检测是否是字符碎片
	 * @return
	 * @author juqkai(juqkai@gmail.com) 2010-10-25
	 */
	public boolean isCharSequence() {
		return CharSequence.class.isAssignableFrom(zlass);
	}
	/**
	 * @return 当前对象是否为数字
	 */
	public boolean isNumber() {
		return Number.class.isAssignableFrom(zlass)
				|| zlass.isPrimitive()
				&& !is(boolean.class)
				&& !is(char.class);
	}
	/**
	 * @return 当前对象是否为字符
	 */
	public boolean isChar() {
		return is(char.class) || is(Character.class);
	}
	/**
	 * @return 当前对象是否为布尔
	 */
	public boolean isBoolean() {
		return is(boolean.class) || is(Boolean.class);
	}
	/**
	 * 判断当前对象是否为一个类型。精确匹配，即使是父类和接口，也不相等
	 * 
	 * @param type
	 *            类型
	 * @return 是否相等
	 */
	public boolean is(Class<?> type) {
		return null != type && zlass == type;
	}
	
	

}
