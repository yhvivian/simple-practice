package com.zhuanzhuan.algorithm;
import com.google.gson.Gson;
/**
 * @author yinhui
 * @version Aug 9, 2016
 * @brief 堆排序算法
 *   完全二叉树的定义：只有最下面的两层结点度能够小于2，并且最下面一层的结点都集中在该层最左边的若干位置的二叉树
 *   堆的定义：满足如下性质的完全二叉树：树中任一非叶子节点的关键字均不大于（或不小于）其左右孩子（若存在）节点的关键字
 *   堆的存储：一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。它的左右子结点下标分别为2 * i + 1和2 * i + 2。
 *   
 *   1、建立最大堆  从有左右子树的结点开始调整堆，保证父节点大于其左右子树
 *   2、选择顶，并与第0位置元素交换 
 *   3、由于步骤2的的交换可能破环了最大堆的性质，第0不再是最大元素，需要调用maxHeap调整堆(沉降法)，如果需要重复步骤2
 *   
 *   复杂度分析：（nlogn） 
 *   
 *   稳定是指排序前2个2个相同数的相对位置，排序后他们的相对位置还是不变。 
 */ 
public class HeapSort {

	private static Gson gson = new Gson();
	 
	public static void main(String[] args)
	{
		int[] arr = new int[]{5, 8, 1, 10, 7, 15};
		headSort(arr);
		System.out.println(gson.toJson(arr));
	}
		
	public static void headSort(int[] arr)
	{
		if(null == arr || arr.length == 0)
			return;
		
		buildMaxHead(arr, arr.length);
		for(int i = arr.length-1; i >= 1; i--)
		{
			exchangeElement(arr, 0, i);
			maxHead(arr, i, 0);
		}		
	}	
	
	public static void buildMaxHead(int[] arr, int length)
	{
		int half = length/2-1;
		for(int i = half; i>=0;i--)// 从有左右子树的结点开始调整堆		
			maxHead(arr, arr.length, i);		
	}
	
	public static void maxHead(int[] arr, int length, int index) //调整第i各结点 
	{
		int largest = index;
		int left = 2*index + 1;
		int right = 2*index + 2;
		
		if(left<length && arr[largest] < arr[left])
			largest = left;
		
		if(right<length && arr[largest] < arr[right])
			largest = right;
		
		if(index != largest)
		{
			exchangeElement(arr, index, largest);		
			maxHead(arr, length, largest); //这个递归怎么没有退出条件呀？		
		}	
	}
	
	public static void exchangeElement(int[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
