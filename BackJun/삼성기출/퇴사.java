// https://www.acmicpc.net/problem/14501

import java.util.Scanner;

public class Main {

	static int[] times;
	static int[] profits;
	static int t;
	static int max= 0 ;
	public static void main(String agrs[]) {
		
		Scanner sc =new Scanner(System.in);
		
		int maxi =0 ;
		t= sc.nextInt();
		
		 times = new int[t];
		 profits = new int[t];
		
		int day = -1 ;
		
		for(int i=0; i<t; i++) {
			
			times[i] = sc.nextInt();
			profits[i] = sc.nextInt();
			
			//선택 불가능한 업무는 times가 -1
			if(i+times[i] > t) {
				
				times[i] = -1;
			}
		
			
		}
		
		// 브루트 포스 가즈아.
		
	
		for(int i=0; i<t ;i++) {
//			Log(i);
		
			dfs(i,0);
		
		
		
		}
		
		
		System.out.println(max);
		
		
		
		
	}
	
	public static void dfs( int index, int score) {
		
		if(times[index] == -1) return;
		
		
		int nextIndex = index+times[index];
		
		int nowScore = score + profits[index];
		
		if(nowScore > max) {max = nowScore;} 
		
		for(int i=nextIndex; i<t; i++) {
			
			dfs(i,nowScore);
		}
		
		
	}
	
	public static void Log(int index) {
		System.out.println(times[index] +" "+ profits[index]);
	}
	
	
	
}
