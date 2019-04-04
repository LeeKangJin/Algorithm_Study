// https://www.acmicpc.net/problem/14502

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static int sero;
	static int garo;
	static ArrayList<cor> InitBiras = new ArrayList<cor>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] tempMap;
	static int max =0;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		sero = sc.nextInt();
		garo = sc.nextInt();
		
		
		map = new int[garo][sero];
		 tempMap = new int[garo][sero];
		
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				int temp = sc.nextInt();
				map[j][i] = temp;
				tempMap[j][i] =temp;
				
				if(temp == 2) {
					InitBiras.add(new cor(j,i));
				}
				
			}
		
		}
		//brute force.
		
			for(int i=0; i<garo; i++) {
				for(int j=0; j<sero; j++) {
					
					
					for(int ii=0; ii<garo; ii++) {
						for(int jj=0; jj<sero; jj++) {
							
							
							for(int iii=0; iii<garo; iii++) {
								for(int jjj=0; jjj<sero; jjj++)	
								{
									
									
									
									if(i == ii && j == jj) {
										continue;
										}
									
									if(i == iii && j == jjj) {
										continue;
										}
									
									if(ii== iii && jj== jjj) {
										continue;
										}
									
									if(map[i][j] == 2 || map[i][j] == 1 ||
										map[ii][jj] == 2 || map[ii][jj] == 1 ||
										map[iii][jjj] == 2 || map[iii][jjj] == 1 )
										continue;
										
									map[iii][jjj] =1;
									map[ii][jj] = 1;
									map[i][j] = 1;
									
									spreadVirus();
									
									DeepCopy();
									
									
									map[iii][jjj] =0;
									map[ii][jj] =0;
									map[i][j] = 0;
									
									
									
								}
							}
						}
					}
				}
			
			}
		
		System.out.println(max);
			
		
		
	}
	public static void DeepCopy() {
		int count =0;
		
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				if(map[j][i] ==0)
					count++;
				
				map[j][i] =tempMap[j][i];
			}
		}
		if(max < count) {
			max = count;
		}
	}
	
	public static void log() {
		for(int i= 0;i<sero; i++) {
			for(int j=0; j<garo; j++) {
				System.out.print(map[j][i] +" ");
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(int x, int y) {
		
		map[x][y] = 2;
	
		
		for(int i=0; i<4; i++) {
			int tx = x+dx[i];
			int ty = y+dy[i];
			
			if(tx <0|| ty<0 || tx>=garo || ty>=sero)
				continue;
			
			if(map[tx][ty] ==1 || map[tx][ty] ==2)
				continue;
			
			
			dfs(tx,ty);
			
			
		}
				
	}
	
		
	
	
	public static void spreadVirus() {
		
		
		for(int i=0; i<InitBiras.size(); i++) {
			
			cor virus = InitBiras.get(i);
			dfs(virus.x,virus.y);
		
		}
		
	}
	

}

class cor{
	int x;
	int y;
	public cor(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}