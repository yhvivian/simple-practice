package com.zhuanzhuan.practice;


/*给一组每天的股价，算出用户应该合适买入、买出才能获得最大收益
 * o(n) 的时间复杂度  o(1)的空间复杂度
 * 
 * 当当天的股票值小于前期的低点时，才会去更新阶段最低股票值。也就是说，股票没有跌破前面几天的最低点的小波动，仍然被算作一个上升期。
 */
public class SharesMaxProfit {

	public static void main(String[] args) {
		
		int[] a={3,15,1,8, 20, 22};
		int[] env={0,0};
		env[0] = a[0];//最低点
		env[1] = a[0];//最高点
		int maxD=0; //最大利润
		
		for(int i =0; i< a.length; i++){
			if(a[i] > env[1]){
				env[1] = a[i];
				if(maxD < env[1] - env[0])
					maxD = env[1] - env[0];				
			}else if(env[0] < a[i]){				
				env[0] =  a[i];
				env[1] =  a[i];
			}
		}	
		System.out.print(maxD);
	}
}
