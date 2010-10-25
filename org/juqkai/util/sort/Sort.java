package org.juqkai.util.sort;

import java.util.List;


public class Sort {
	/**
	 * 冒泡排序
	 * @param <T> 实现了排序接口的类
	 * @param sourceObjs 需要排序的List,需要注意的是,本方法是直接在这个List上进行的排序,因此会对原始list进行修改
	 */
	public static <T extends ISort> void bubbleSort(List<T> sourceObjs){
		for(int i = 0; i < sourceObjs.size(); i++){
			T gei = sourceObjs.get(i);
			for(int j = i; j < sourceObjs.size(); j++){
				T gej = sourceObjs.get(j);
				if(gei.value() < gej.value()){
					sourceObjs.set(i, gej);
					sourceObjs.set(j, gei);
				}
			}
		}
	}
}
