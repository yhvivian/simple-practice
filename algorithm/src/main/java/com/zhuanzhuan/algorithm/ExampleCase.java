package com.zhuanzhuan.algorithm;

public class ExampleCase {
	
	
	public static void main(String[] args)
	{	
		System.out.println(getMaxValue(new int[]{2,5, 10, 1,20}));
	}
	
	/*
	 * 判断一个int数组中是否存在重复  bitmap适合处理海量数据
	 */
	public static boolean isRepeat(int[] m)
	{
		int length = m.length % 32 >0 ? m.length/32 + 1 : m.length/32;
		int[] bitMap = new int[length]; 
		boolean flag = false;
		for(int i = 0; i< m.length; i++)
		{			
		   flag = juge(bitMap, m[i]/32, m[i]%32);
		   System.out.println(" m=" + m[i] + " flag=" + flag);	
		   if(flag)
			   break;
		}
		return flag;
	}
	
	public static boolean juge(int[] bitMap, int index, int pos)
	{
		int posValue = getBitBypos(bitMap[index], pos);
		if(0 == posValue){
			bitMap[index] = setBitBypos(bitMap[index], pos);
			return false;
		}else
			return true;		
	}
	
	public static int setBitBypos(int num, int pos)
	{
	    num |= (1 << pos);
		//System.out.println("pos=" + (pos << 1) + " num=" + num + " pos=" + pos);
		return num;
	}
	
	public static int getBitBypos(int num, int pos)
	{
		int flag = (num>>pos) & 1;	
		//System.out.println("flag=" + flag + " num=" + num + " pos=" + pos);
		return  flag;
	}
	
	
	/**
	 * @brief 返回一个int数组中最大的值
	 *         解法1 最大堆 o(logn)
	 *         解法2 循环遍历一遍o(n)
	 * @param m
	 * @return
	 */
	static int getMaxValue(int[] m)
	{		
		int max = m[0];
		for(int i =0; i< m.length;i++)
		{
			if(m[i]>max)
				max=m[i];
		}		
		return max;
	}
	
	
	/*已知有一长度为100的无序随机整型数组，且数值范围是[1,100]，写一算法，
	 * 判断数组中是否有存在重复值，要求，不得嵌套循环，不得使用递归。*/
	
	public static boolean chechRepeat(int numArry[] )
	{
		if(null == numArry || numArry.length == 0)
			return false;
		int[] a = new int[numArry.length];
		for(int i = 0; i < numArry.length ; i ++)
		{
			int num = numArry[i];
			if(a[num] != 0)
				return true;
			else
				a[num] = 1;
		}
		return false;
	}
	
}
