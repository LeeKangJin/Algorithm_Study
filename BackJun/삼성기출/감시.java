//https://www.acmicpc.net/problem/15683


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
//	final int ONE_CCTV =1;
//	final int LR_CCTV= 2;
//	final int UR_CCTV =3;;
//	final int THREE_CCTV =4;
//	final int FOUR_CCTV= 5;
//	final int WALL = 6;
	static int min = 9999999;
	final static int LEFT =1;
	final static int RIGHT =2;
	final static int UP =3;
	final static int DOWN =4;
	static ArrayList<cctv> cctvs = new ArrayList<cctv>();
	
	// 첫번쨰 시도 메모리를 최대한 써서 풀어본다. 
	public static void main(String[] args) {
		
		
		
		Scanner sc =new Scanner(System.in);
		
		int sero = sc.nextInt();
		int garo = sc.nextInt();
		int[][] map = new int[garo][sero];
		int t =0;
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
							t= sc.nextInt();
							map[j][i] = t;
							
							if(t == 1 ) {cctvs.add(new cctv(j,i,1));}
							
							else if(t==2) {cctvs.add(new cctv(j,i,2));}

							else if(t==3) {cctvs.add(new cctv(j,i,3));}

							else if(t==4) {cctvs.add(new cctv(j,i,4));}

							else if(t==5) {cctvs.add(new cctv(j,i,5));}
			
			
			}

		}
		dfs(map,0);
		System.out.println(min);
		
		}
	
	
	
		public static void dfs(int[][] map, int index) {
			
			//마지막단계
			if(index == cctvs.size()) {
			
			int t = 0;
				for(int i= 0; i<map[0].length; i++) {
					for(int j=0; j<map.length; j++) {
						if(map[j][i] == 0)
							t++;
					}
				}
			if(min > t)
				min = t;
			
			return ;
			}
			
			else if( index < cctvs.size()) {
				
				for(int i=1 ;i<5; i++) {
				
					int[][] temp = new int[map.length][map[0].length];
					temp = deepCopy(map, temp);
					map = layser(map,cctvs.get(index),i);
//					mapPrint(map);
					dfs(map,index+1);
					map = temp;
					
				}
				
			
			}
			
			
		
		}
	
		public static int[][] deepCopy(int[][] befo, int[][] after){
			
			for(int i=0; i<befo[0].length;i++) {
				for(int j=0; j<befo.length; j++) {
					after[j][i] = befo[j][i];
				}
			}
			
			return after;
		}
		
		public static void mapPrint(int[][] map) {
			for(int i=0; i<map[0].length; i++) {
				for(int j=0; j<map.length; j++) {
					System.out.print(map[j][i]);
				}
				System.out.println();
			}
			System.out.println();
		}
	
		public static int[][] layser(int[][] map, cctv ct, int point){
	
			switch(ct.type)
			{
			case 1:{
				switch(point) {
				case LEFT:{	
					map = leftLayser(map,ct);
					break;
				}
				
				case RIGHT:{
					map = rightLayser(map,ct);
					break;
				}
				case UP:{
					map = upLayser(map, ct);
					break;
				}
				case DOWN:{
					map = downLayser(map, ct);
					break;
				}
				
				}
				
				break;
			}
			case 2:{
				switch(point) {
				case LEFT:{	
					map = leftLayser(map,ct);
					map = rightLayser(map,ct);
					break;
				}
				
				case RIGHT:{
					map = rightLayser(map,ct);
					map = leftLayser(map, ct);
					break;
				}
				case UP:{
					map = upLayser(map, ct);
					map = downLayser(map, ct);
					break;
				}
				case DOWN:{
					map = downLayser(map, ct);
					map = upLayser(map, ct);
					break;
				}
				
				}
				break;
			}
			case 3:{
				switch(point) {
				case LEFT:{	
					map = leftLayser(map,ct);
					map = downLayser(map,ct);
					break;
				}
				
				case RIGHT:{
					map = rightLayser(map,ct);
					map = upLayser(map,ct);
					break;
				}
				case UP:{
					map = upLayser(map, ct);
					map = leftLayser(map,ct);
					break;
				}
				case DOWN:{
					map = downLayser(map, ct);
					map = rightLayser(map,ct);
					break;
				}
				
				}
				break;
			}
			case 4:{
				switch(point) {
				case LEFT:{	
					map = leftLayser(map,ct);
					map = downLayser(map,ct);
					map = upLayser(map,ct);
					break;
				}
				
				case RIGHT:{
					map = rightLayser(map,ct);
					map = upLayser(map,ct);
					map = downLayser(map,ct);
					break;
				}
				case UP:{
					map = upLayser(map, ct);
					map = leftLayser(map,ct);
					map = rightLayser(map,ct);
					break;
				}
				case DOWN:{
					map = downLayser(map, ct);
					map = leftLayser(map,ct);
					map = rightLayser(map,ct);
					break;
				}
				
				}
				break;
			}
			case 5:{
				 map = leftLayser(map,ct);
				 map = rightLayser(map,ct);
				 map = upLayser(map,ct);
				 map = downLayser(map, ct);
				 break;
			}
		
			}
			
			return map;
		}
	
	
	
		public static int[][] upLayser(int[][] map, cctv ct){
		int x = ct.x;
		int y=  ct.y;
		for(int i=y; i>=0; i--) {
			if( map[x][i] ==6)
				break;
			else {
				map[x][i] = -1;
			}
		}
		
		
		return map;
		}
		
		public static int[][] downLayser(int[][] map, cctv ct){
			int x = ct.x;
			int y= ct.y;
			int size = map[0].length;
			for(int i=y; i<size; i++) {
			
				if(map[x][i] == 6)
					break;
				else
					map[x][i] = -1;
			
			}
			
//			mapPrint(map);
			return map;
			}
	
		public static int[][] rightLayser(int[][] map, cctv ct){
			int x = ct.x;
			int y= ct.y;
			int size = map.length;
			
			for(int i=x; i<size; i++) {
				if(map[i][y] ==6)
					break;
				else
					map[i][y] = -1;
			}
			
			
			
			return map;
		
		}
	
		public static int[][] leftLayser(int[][] map, cctv ct){
			int x = ct.x;
			int y = ct.y;
			
				for(int i=x; i>=0; i--) {
					if(map[i][y] == 6)
						break;
					else
						map[i][y] = -1;
		}
				return map;
		}

}

class cctv{
	int x;
	int y;
	int type;
	public cctv(int x, int y, int type) {
		
		this.x = x;
		this.y = y;
		this.type = type;
	}
}


	
	
