package com.zhuanzhuan.algorithm;

import com.google.gson.Gson;

/**
 * @author yinhui
 * @version Aug 10, 2016
 * @brief 快速排序
 */
public class QickSort {

	public static void qickSort(int[] arr, int start, int end) //arry的起始 和 结束下标
	{
		if(null == arr || arr.length==0 || start < 0  || end <= start)
			return;
		int i = start;
		int j = end;
		int key = arr[start];
		while(i<j && j>=0)
		{
			while(i<j && arr[j]>key)
				j--;
			/*if(arr[j]<key){
				arr[i] = arr[j];
				i++;
			}*/
			arr[i] = arr[j];
			while(i<j && arr[i]<key)
				i ++;
			/*if(arr[i]>key){
				arr[j] = arr[i];
				j--;
			}*/
			arr[j] = arr[i];
				
		}
		arr[i] = key;
		System.out.println("key："+key+"\tI--:"+i);
		show(arr);
		qickSort(arr, start, i-1);
		qickSort(arr, i+1, end);
	}
	public static void show(int[] arr){
		for(int i:arr){
			System.out.print(i+"-");
		}
		System.out.println("");
	}
	public static void main(String[] args)
	{
		int[] arr = new int[]{3, 5, 1, 2, 10};
		qickSort(arr, 0, arr.length-1);
		System.out.println(new Gson().toJson(arr));
	}
}
