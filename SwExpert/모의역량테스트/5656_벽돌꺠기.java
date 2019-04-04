
//https://www.swexpertacademy.com/main/solvingProblem/solvingProblem.do
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int max_dist=Integer.MAX_VALUE;
	
	static int debugNumber =0;
	static int n;
	static int xMax;
	static int yMax;

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int z=0; z<t; z++) {
			n =0;
			xMax =0 ;
			yMax =0 ;
			max_dist=Integer.MAX_VALUE;
			
			n = sc.nextInt();
			int garo = sc.nextInt();
			int sero = sc.nextInt();
			
			xMax = garo;
			yMax = sero;
			int block_count =0;
			
			int[][] map = new int[garo][sero];
			
			
			for(int i=0; i<sero; i++) {
				for(int j=0; j<garo; j++) {
					map[j][i] = sc.nextInt();
					
					if(map[j][i] != 0 )
						block_count ++;
					
				}
			}
			
			dfs(map);
			
			System.out.println("#"+(z+1)+" "+max_dist);
		}
		
		
	}
	
	
	
	//TO DO temp로 바꾸
	//시간 초과 뜨면 여길 고쳐야
	public static int[][] downZero(int[][] map){
		
		int temp;
		int count = 0;
		
		int[][] tempMap = new int[xMax][yMax];
		
		for(int i=0; i< xMax; i++) {
			for(int j=0; j<yMax; j++) {
				tempMap[i][j] = 0;
			}
			
		}
		
		
		// x 가 0 ~ xMax까지
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=0; i<xMax; i++) {			
			q.clear();
			for(int j=yMax-1; j>=0; j--) {
				
				if(map[i][j] != 0 ) {
					q.add(map[i][j]);
					count ++;
				}
				
			}
			
			int qSize = q.size();
			for(int j=0; j<qSize; j++) {
				tempMap[i][yMax- j-1] = q.poll();
				
			}
			

		}
		
		if(count < max_dist)
			max_dist = count ;
		
		
		return tempMap;
	}
	
	
	public static mapNmax blockDestroy(int x,int y,int[][] map,int maxValue) {
		
		mapNmax temp = new mapNmax(map,maxValue);
		
		if(x < 0 || y <0 || y >= yMax || x >= xMax)
			return temp;
		
		int blockNum = map[x][y];
		//본 블럭은 부숴지고
//				temp.max++;
				map[x][y] = 0;
//				map = downZero(map,x,y);
				
		if(x > 0) {
		 temp = destroy_left(x,y,map,maxValue,blockNum);
		}
		
		if(x < xMax) {
		 temp = destroy_right(x,y,map,maxValue,blockNum);
	
		}
	
		if(y > 0) {
		temp = destroy_up(x,y,map,maxValue,blockNum);
	
		}
		if(y < yMax) {
			
		temp = destroy_down(x,y,map,maxValue,blockNum);
		
		}
		
		
		return temp;
	}
	public static mapNmax destroy_left(int x, int y, int[][] map,int maxValue,int count){
		
	
		mapNmax temp = new mapNmax(map,maxValue);
		
		for(int i=1; i<count; i++) {
			
			temp =  blockDestroy(x-i,y,temp.map,temp.max);
			
		}
		
		
		return temp;
	}
	
	public static mapNmax destroy_right(int x, int y, int[][] map,int maxValue,int count){
		
		mapNmax temp = new mapNmax(map,maxValue);
		
		for(int i=1; i<count; i++) {
			temp =  blockDestroy(x+i,y,temp.map,temp.max);
			
		}
		
		return temp;
	}
	
	public static mapNmax destroy_up(int x, int y, int[][] map,int maxValue,int count){
		
		mapNmax temp = new mapNmax(map,maxValue);
		
		for(int i=1; i<count; i++) {
			temp =  blockDestroy(x,y-i,temp.map,temp.max);
			
		}
		
		return temp;
	}
	
	public static mapNmax destroy_down(int x, int y, int[][] map,int maxValue,int count){
		
		mapNmax temp = new mapNmax(map,maxValue);
		
		for(int i=1; i<count; i++) {
			temp =  blockDestroy(x,y+i,temp.map,temp.max);
			
		}
		
		return temp;
	}
	
	
	
	
	
	public static void block_bomb(int xPoint,int[][] map,int count,int maxValue) {
		
		
			int temp_count = count;
			int y =0;
			int temp_maxValue = maxValue;
			int[][] temp_map =mapDeepCopy(map);
			mapNmax temp = new mapNmax(temp_map,temp_maxValue);
		
		
			if(temp_count == n) // 시도 회수 넘었다.{
			{
				return;
			}
			
		
			
			while(true)
			{
				// TODO >인지, >=인지 확인좀
			
			
				if( y < yMax)
				{
					if( map[xPoint][y] != 0)
					{
						//해당 블록 제거 여긴 deep copy 필요 없는 지역
					
//						if(count ==0 && xPoint ==2) {
//							System.out.println();
//							debugNumber++;
//							
//						}
//						if(count ==1 && xPoint ==2) {
//							System.out.println();
//							debugNumber++; 
//						}
//						if(count ==2 && xPoint ==6) {
//							System.out.println();
//							debugNumber++;
//						}
//						
//						if(debugNumber == 27) {
//							System.out.println();
//						}
				
						
						temp = blockDestroy(xPoint,y,temp_map,temp_maxValue); 
						//여기서 숫자세자..
						temp.map = downZero(temp.map);
						//한칸 내려와야됨..
					
						break;
					}
					
					
				}
				else
					break;
				y++;
			}
			//뿌셔진 만큼 maxValue 값을 추가하기.
			//뿌셔진 만큼 map 바꾸기.
			
			
			temp_count = count +1;
			temp_map = temp.map;
		
//			System.out.println("Lound:"+count+"   x:"+xPoint);
//			mapLog(temp.map);
			
			//다음 시행에서 x포인트를 0~ 10까지.
			for(int i=0; i<xMax; i++) {
				
				block_bomb(i,temp_map,temp_count,maxValue);
				
			}	
			
			
	}
	
	
	public static int[][] mapDeepCopy(int[][] map){
		
		int[][] tempMap = new int[xMax][yMax];
		
		for(int i=0; i<yMax; i++) {
			
			for(int j=0; j<xMax; j++) {
			
				tempMap[j][i] = map[j][i];			
		
			}
		}	
		return tempMap;
	}
	
	public static void mapLog(int[][] map) {
		for(int i=0; i<yMax; i++) {
			for(int j=0; j<xMax; j++) {
				System.out.print(map[j][i]);
				System.out.print(" ");			
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void dfs(int[][] map) {
		
		for(int i=0; i<xMax; i++) {
			
			block_bomb(i,map,0,0);
			
		}
		
		
	}

}

class mapNmax{
	int[][] map;
	int max;
	
	public mapNmax(int[][] map, int max) {
	
		this.map = map;
		this.max = max;
	}
	
	
	
}
