package com.zhuanzhuan.algorithm;

public class BitMapCase {

	public static boolean isInArray(int numArr[], int a)
	{
		if(null == numArr ||  numArr.length == 0 || a< 0 )
			throw new IllegalArgumentException(); //参数错误
		int length = numArr.length%32 >0 ? numArr.length/32 + 1 : numArr.length/32; //一个整型32位，除了符号位可以表示0~31之间的数字
		int[] bitMap = new int[length];//申请的控件有问题 取决于数组中最大值 
		initBitMap(bitMap, numArr);		
		boolean flag = findNum(bitMap, a);				
		return flag;
	}
	
	public static void initBitMap(int[] bitMap, int[] numArr) //初始化bitMap
	{
		for(int i=0 ; i < numArr.length; i++)
		{
			int index = getIndex(numArr[i]);
			int pos = getPos(numArr[i]);
			getBitMapValue(index, pos, bitMap);
		}
	}
	
	public static int getIndex(int num) //在bitmap数组中的index
	{
		return num / 32;
	}
	
	public static int getPos(int num) //bitmap整数的bit位
	{
		return num % 32;
	}
	
	public static void getBitMapValue(int index, int pos, int[] bitMap) //将bitmap的对应位置置1
	{
		int num = setBitByPos(bitMap[index], pos, 1);
		bitMap[index] = num;		
	}
	
	//将整数的对应bit位置1 或 0
	public static  int setBitByPos(int num, int pos, int setNum)
	{
		if(pos > 31 || pos < 0)
			return 0;
		if(1 == setNum)
			num |= (1 << pos);
		else
			num &= ~(1 << pos);
		return num;		
	}
	
	//判断pos位置的bit是否为1
	public static boolean findNum(int[] bitMap, int value)
	{
		int index = getIndex(value);
		int pos = getPos(value);	
		if(index >= bitMap.length)
			return false;
		int flag = jugeBitByPos(bitMap[index], pos);
		return flag == 1 ? true : false;
	}
	
	public static int jugeBitByPos(int num, int pos)
	{
		int posValue = (num >> pos)&1;
		return posValue == 1 ? 1 : 0;
	}
	
	public static void main(String[] args)
	{
		System.out.println(Integer.MAX_VALUE);
		int searchNum = 120;
        int[] numArr = {63, 64, 45, 56, 0, 54, 28, 2, 23, 34, 40, 18, 54, 50, 49, 29, 20, 31, 47, 30, 24, 17, 50, 57, 33, 55, 21, 22, 27, 45, 3, 19, 17, 49, 24, 5, 15, 24, 27, 35, 6, 53, 9, 61, 4, 6, 12, 23, 52, 48, 39, 39, 21, 1, 11};
		boolean flag = isInArray(numArr, searchNum);
		System.out.println("flag=" +  flag);
	}
}
