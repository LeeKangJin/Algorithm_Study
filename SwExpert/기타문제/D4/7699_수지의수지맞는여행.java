import java.util.Scanner;

public class SugiTrip {
	
	 static int maxiNumber = Integer.MIN_VALUE;
	 static int dx[] = {-1,1,0,0};
	 static int dy[] = {0,0,1,-1};
	 static int garo;
	 static int sero;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int z=0; z<t; z++) {
			sero = sc.nextInt();
			garo = sc.nextInt();
			maxiNumber = Integer.MIN_VALUE;
			char map[][] = new char[garo][sero];
			
			for(int i=0; i<sero; i++) {
				String input = sc.next();
				char[] temp = input.toCharArray();
				
				for(int j=0; j<garo; j++) {
					map[j][i] = temp[j];
				}
				
			}
			//log(map);
			boolean[] visit = new boolean[26];
			
			play(map,visit,0,0,0);
			
			
			
			System.out.println("#"+(z+1)+" "+(maxiNumber+1));
		}
		
	}
	
	public static void play(char[][] map, boolean[] visit,int x, int y,int count) {
		
		int check = map[x][y] -65;
		
		if(visit[check]) {
			
			
			
		}
		
		
		
		visit[check] = true;
		
		
		for(int i=0; i<4; i++) {
			int tx = x+dx[i];
			int ty = y+dy[i];
			
			
			
			if(tx < 0 || ty <0 || tx>=garo || ty>= sero)
				continue;
			
			int tcheck = map[tx][ty]-65;
			
			if(visit[tcheck]) {
				
				if(maxiNumber<count)
					maxiNumber = count;
				
				continue ;
				
			}
			else {
				count++;
				play(map,visit,tx,ty,count);
				count--;
			}
			
		}
		
		visit[check] = false;
		

		
	}
	
	
	public static void log(char[][] map) {
		System.out.println();
		for(int i=0; i<map[0].length; i++) {
			for(int j=0; j<map.length; j++) {
				System.out.print(map[j][i]+" ");
				
			}
			System.out.println();
			
		}
		
		
	}
	
}
