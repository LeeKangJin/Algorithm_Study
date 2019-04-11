//https://www.swexpertacademy.com/maQin/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo


import java.util.Scanner;

public class Solution {

	static int n;
	static cor[] key = new cor[5];
	static cor[] value = new cor[5];
	
	final static int L = 11;
	final static int R = -11;
	final static int U = 22;
	final static int D = -22;
	static int maxCount =0;
	static int[][] map;
	
	public static void insertWarmHole(int WarmNumber,int x, int y) {
		
		for(int i=0; i<5; i++)
			if(WarmNumber == 6+i) {
				if(key[i].x == 0 && key[i].y == 0)
				{
					key[i].x = x; key[i].y = y;
				}
				else {
					value[i].x =x;
					value[i].y =y;
				}
				break;	
		}
		
	}
	public static void warmInit() {
		
		for(int i=0; i<5; i++) {
			cor keytemp =new cor(0,0);
			cor valuetemp = new cor(0,0);
			
			key[i] = keytemp;
			value[i] = valuetemp;
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int z=0; z<t; z++) {
			 n = sc.nextInt();
			 map = new int[n+2][n+2];
			 maxCount =0;
			 warmInit();
			 for(int i=0; i<n+2; i++) {
				 for(int j=0; j<n+2; j++) {
					 
					 if(i==0 || j==0 || i == n+1 || j== n+1)
					 {
						 map[j][i] = 5;
						 continue;
					 }
					 
					 
					 
					 map[j][i] = sc.nextInt();
				 
					 if(map[j][i] >=6 && map[j][i] <= 10 )
						 insertWarmHole(map[j][i],j,i);
					
				 
				 }
			 }
			 fin ball = new fin(new cor(0,0), R);
			 
			 int count =0;
			 int temp =0;
			 for(int i=1; i<n+1; i++) {
				 for(int j=1; j<n+1; j++) {
		
					 if ( map[j][i] == 0) {
					
					 
					 count =0;
					 temp =0;
					 ball.dir = R;
					 ball.position.x = j;
					 ball.position.y = i;
					 count = move(ball);
					 
					 
					 ball.dir = L;
					 ball.position.x = j;
					 ball.position.y = i;
					 temp = move(ball);
					 
					 if(count <temp)
						 count = temp;
					 
					 
					 ball.dir = U;
					 ball.position.x = j;
					 ball.position.y = i;
					 temp = move(ball);
					 
					 if(count <temp)
						 count = temp;
					 
					 ball.dir = D;
					 ball.position.x = j;
					 ball.position.y = i;
					 temp = move(ball);
					 
					 if(count <temp)
						 count = temp;
					 
					 if(maxCount <count)
						 maxCount = count;
				 }
				}
			 }
			 System.out.println("#"+(z+1)+" "+maxCount);
	}
}
	
	
		public static int move(fin f) {
			
			
			int corx;
			int cory;
		
			int initx = f.position.x;
			int inity = f.position.y;
			int count =0;
	
			
			while(true) {
			
				f.finMove();
				
				corx= f.position.x;
				cory= f.position.y;
				
				if(initx == corx && inity == cory)
					break;
				
				int temp =map[corx][cory];
				
				if(temp == 0 ) continue;
				
				else if(temp == -1) {
					break;
				}
				else if(temp >= 1 && temp <=5)
				{
					count+=f.dirChange(temp);
				}
				else {
					int number = temp -6;
					
					if(key[number].x ==corx && key[number].y ==cory) {
						f.position.x = value[number].x;
						f.position.y = value[number].y;
					}
					else {
						f.position.x = key[number].x;
						f.position.y = key[number].y;
					}
					
				}
				
			
		}
			
			return count;
	}
	
	
	}
	
	

class fin{
	cor position;
	int dir;
	
	final static int L = 11;
	final static int R = -11;
	final static int U = 22;
	final static int D = -22;
	public fin(cor position,  int dir) {
		this.position = position;
		this.dir = dir;
	}
	public void finMove() {
		
		if(dir == L) position.x--;
		else if(dir == R) position.x++;
		else if (dir == U) position.y --;
		else if (dir == D) position.y++;
		
		
	}
	
	public int dirChange(int b) {
		int type = b;
		int d = this.dir;
	
		switch(type) {
	
		case 1:{
			if(d == L) this.dir = U;
			else if(d == R) this.dir = L;
			else if(d == U) this.dir = D;
			else if(d == D) this.dir = R;
			return 1;
		}
		case 2:{
			if(d == L) this.dir = D;
			else if(d == R) this.dir = L; 
			else if(d == U) this.dir = R;
			else if(d == D) this.dir = U;
			
			return 1;
		}
		case 3:{
			if(d == L) this.dir = R;
			else if(d == R) this.dir = D; 
			else if(d == U) this.dir = L;
			else if(d == D) this.dir = U;

			return 1;
		}
		case 4:{
			if(d == L) this.dir =  R;
			else if(d == R) this.dir = U;
			else if(d == U) this.dir = D;
			else if(d == D) this.dir = L;

			return 1;
		}
		case 5:{
			if(d == L) this.dir = R;
			else if(d == R) this.dir = L; 
			else if(d == U) this.dir = D;
			else if(d == D) this.dir = U;

			return 1;
		}
		
		}
		return 0;
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
