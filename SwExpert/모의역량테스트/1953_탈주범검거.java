//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq

import java.util.Scanner;

public class Solution {
	
	//구조물 1~8
	// 상, 하 , 좌, 우 ( 없으면 0 )
	int[] type1 = {1,1,1,1};
	int[] type2 = {1,1,0,0};
	int[] type3 = {0,0,1,1};
	int[] type4 = {1,0,1,0};
	int[] type5 = {0,1,0,1};
	int[] type6 = {0,1,1,0};
	int[] type7 = {1,0,1,0};
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int sero;
	static int garo;
	static int time;
	static int[][] menhole;
	static boolean[][] visit; 
	static int count =0;
	//정리 
	//RIGHT 가능 -> 본인 (1,3,4,5) 타인 (1,3,6,7)
	//LEFT 가능 -> 본인  (1,3,6,7) 타인 (1,3,4,5)
	
	
	//DOWN 가능 -> 본인 (1,2,5,6) 타인 (1,2,4,7)
	//UP 가능 ->   본인 (1,2,4,7) 타인 (1,2,5,6)
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
	
	
		int menhole_sero;
		int menhole_garo;

		for(int i = 0; i<test_case; i++) {
			sero = sc.nextInt();
			garo = sc.nextInt();
			menhole_sero = sc.nextInt();
			menhole_garo = sc.nextInt();
			time = sc.nextInt();
			
			count = 0;
			visit = new boolean[garo][sero];
			menhole = new int[garo][sero];//Integer가 널체크 가능
			
			for(int j=0; j<sero; j++) {
				for(int k=0; k<garo; k++) {
					visit[k][j] = false;
					menhole[k][j] = sc.nextInt();
				}
			}
			DFS(menhole_garo,menhole_sero,-1,0);
			//log();
			System.out.println("#"+(i+1)+" "+count);
		}
		
		
	}
	public static void log() {
		System.out.println();
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				
				if(!visit[j][i])
					System.out.print("? ");
				
				else
					System.out.print("! ");
				
			}
			System.out.println();
		
		}
		
	}
	
	// LEFT= 0, RIGHT= 1, UP = 2, DOWN = 3
	public static void DFS(int x, int y,int dir,int ttime) {
		
		
		if(ttime >= time )
			return;
		
		if(visit[x][y] == false) {
			count++;
			visit[x][y] = true;
		}
		
		int t = menhole[x][y];
		
		for(int i=0; i<4; i++) {
			
			int tx = x+dx[i];
			int ty = y+dy[i];
			
		
			
			if(tx <0 || tx >= garo || ty<0 || ty>=sero)
				continue;
			
			if(menhole[tx][ty] == 0)
				continue;
			
			int at = menhole[tx][ty];
			//LEFT
			if(dx[i] == -1 && dir != 1 ) {
				
				if(t == 1 || t == 3 || t==6 || t==7) {
					
					if(at ==1 || at ==3|| at== 4|| at ==5)
					{
						DFS(tx,ty,0,ttime+1);
					}
					
				}
				
			}
			
			//RIGHT
			if(dx[i] == 1 && dir != 0){
				
				if(t == 1 || t == 3 || t==4 || t==5) {
					
					if(at ==1 || at ==3|| at== 6|| at ==7)
					{
						DFS(tx,ty,1,ttime+1);
					}
					
				}
				
			}
			
			//UP
			if(dy[i] == -1 && dir != 3){
				
				if(t == 1 || t == 2 || t==4 || t==7) {
					
					if(at ==1 || at ==2|| at== 5|| at ==6)
					{
						DFS(tx,ty,2,ttime+1);
					}
					
				}
				
			}
			
			//DOWN
			if(dy[i] == 1 && dir != 2){
				
				if(t == 1 || t == 2 || t==5 || t==6) {
					
					if(at ==1 || at ==2|| at== 4|| at ==7)
					{
						DFS(tx,ty,3,ttime+1);
					}
					
				}
				
			}
			
			
		}
		
		
	}
	
	
	

}
