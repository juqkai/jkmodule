package org.juqkai.util.string;


/**
 * 字符串工具类
 * @author juqkai(juqkai@gmail.com) 2010-7-22
 */
public class Strings {
	/**
	 * 将一组数据按分割符进行组装
	 * @param decollator 分割符
	 * @param value 要进行组装的内容
	 * @return 组装好的字符串
	 */
	public static String joint(String decollator, Object... value ){
		StringBuffer sb = new StringBuffer();
		boolean notFirst = false;
		for(Object s : value){
			if(notFirst){
				sb.append(decollator);
			}
			sb.append(s);
			notFirst = true;
		}
		return sb.toString();
	}
	
	/**
	 * 格式化输出,以{}为点位符,
	 * 示例:
	 * Strings.format("玩家{}不能进行{}操作!","张三","登录");
	 * @param str 原始数据如:ab{}cd{}e{}fg
	 * @param value 要替换的参数如:1,2,3
	 * @return
	 */
	public static String format(String str, Object... value){
		str += "zk";
		String[] strs = str.split("\\Q{}\\E");
		//原始记录分组
		Integer originalCount = strs.length;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < strs.length; i++){
			sb.append(strs[i]);
			if(i + 1 < originalCount && i < value.length){
				sb.append(value[i]);
			}
		}
		return sb.substring(0, sb.length() - 2);
	}
	
	/**
	 * 将字符串转换成整形
	 * @param value
	 * @return
	 */
	public static Integer toInt(String value){
		if(value == null || value == ""){
			return -1;
		}
		try{
			return Integer.parseInt(value);
		}catch(Exception e){
			return -1;
		}
	}
	/**
	 * 将字符串转换成整形
	 * @param value
	 * @return
	 */
	public static Double toDouble(String value){
		if(value == null || value == ""){
			return -1d;
		}
		try{
			return Double.parseDouble(value);
		}catch(Exception e){
			return -1d;
		}
	}
	/**
	 * 第一个字母大写
	 * @param str
	 * @return
	 * @author juqkai(juqkai@gmail.com) 2010-10-25
	 */
	public static String capitalize(String str){
		if(str == null){
			return null;
		}
		if(str.equals("") || str.length() == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Character.toUpperCase(str.charAt(0)));
		sb.append(str.substring(1));
		return sb.toString();
	} 
}
