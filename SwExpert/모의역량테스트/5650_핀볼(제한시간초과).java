//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo



import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	final static int NomalSpace =0;
	final static int TriangleOne = 1; // 상 , 우 
	final static int TriangleTwo = 2; //  우, 하 
	final static int TriangleThree = 3; // 우, 좌
	final static int TriangleFour = 4; // 좌, 상
	final static int Square = 5;
	final static int BlackHole = -1;
	
	final static int UP = 11;
	final static int DOWN = -11;
	final static int LEFT = 22;
	final static int RIGHT = -22;
	
	final static int WarmHole = 6;

	static int maxScore =0;
	
	// 웜홀 저장공간 생성
		static ArrayList<warmHoll> warmHollList = new ArrayList<warmHoll>();
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int z= 0; z<t; z++) {
			int n = sc.nextInt();
			boolean isCheck = false;
			int[][] map = new int [n+2][n+2] ;
			
			warmHollList.clear();
			maxScore =0;
			
			for(int i=0; i<n+2; i++)
			{
				for(int j=0; j<n+2; j++) {
					
					
					if(i == 0 || j == 0 || i == n+1 || j == n+1) {
						map[i][j] = Square;
					}
					else {
						map[j][i] = sc.nextInt();
					}
					//..웜홀 만드는 구간..
					for(int k=0; k<5; k++)
					{
						if(map[j][i] == WarmHole+k) {
							
							//리스트 중에서 이런 number를 가지고 있는 녀석이 있으면 그녀석 second로
							 isCheck = false;
							for(int a=0; a<warmHollList.size(); a++) {
							
								if(warmHollList.get(a).warmHollNumber == WarmHole+k) {
									warmHollList.get(a).setWarmHoll(new coor(j,i));
									isCheck =true;
								}
							
							}
							
							//리스트 중에서 이런 number( WarmHole+k) 를 가지고 있는 녀석이 없으면 new해서 add
							if(isCheck ==false) {
								warmHoll a = new warmHoll();
								a.setWarmHoll(new coor(j,i));
								a.setWarmHollNumber(WarmHole+k);
								warmHollList.add(a);
							}
							
						}
					}
					//..웜홀 만드는 구간..
					
				}
				
			}
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					
					if(map[j][i] == 0)
					{
						dfsAll(j,i,new pinBall(j,i,-1,-1),map);
					}
				}
				
			}
			
			
			System.out.println("#"+(z+1)+" "+maxScore);
		}
		
		
	}
	
	//재귀가 아니라 while문을 이용해보자.
	public static int dfs(int startX,int startY,pinBall pin,int[][] map) {
		
		while(true) {
		//종료조건
		if(pin.score != 0) {
			if(pin.x == startX && pin.y ==startY)
			{
				
				
				if(maxScore < pin.score)
					maxScore = pin.score;
				
				break;
			}
		}
		
		
		
		//작업
		int state = pin.pinBallCheck(map[pin.x][pin.y]);
		
		//블랙홀에 빠짐
		if(state == -1) {
			break;
		}
		
		//웜홀 이동
		if(state == WarmHole) {
			for(int i=0; i<warmHollList.size(); i++) {
				if( warmHollList.get(i).warmHollNumber == map[pin.x][pin.y] ) {
				
					coor a = new coor(pin.x,pin.y);
					coor b = new coor();
					b = warmHollList.get(i).anotherHoll(a);
					pin.x = b.x; pin.y =b.y;
				}	
			}
		}
		
		//핀볼 이동
		pin.pinBallMoving(map);
		
		
		}
		return 0;
	}
	
	
	
	public static void dfsAll(int startX,int startY,pinBall pin,int[][] map) {
		
		int tempX = startX;
		int tempY = startY;
		
		pin.score = 0;
		pin.dir =UP;
		dfs(startX,startY,pin,map);
		
		pin.pinInit(tempX, tempY, DOWN, 0);
		dfs(startX,startY,pin,map);
		
		pin.pinInit(tempX, tempY, LEFT, 0);
		dfs(startX,startY,pin,map);

		pin.pinInit(tempX, tempY, RIGHT, 0);
		dfs(startX,startY,pin,map);
		
		
		
	}
//	public static int[][] mapCopy(int[][] map){
//		int[][] tempMap = new int[n+2][n+2];
//		
//		for(int i=0; i<n+2; i++) {
//			for(int j=0; j<n+2; j++) {
//				tempMap[j][i] =map[j][i];
//			}
//		}
//		
//		return tempMap;
//		
//	}
//	
//	public static void printPin(pinBall a, int[][] map) {
//		int[][] map2 = mapCopy(map);
//		
//		map2[a.x][a.y] = -8;
//		
//		System.out.println();
//		for(int i=0; i<n+2; i++) {
//			for(int j=0; j<n+2; j++) {
//				System.out.print(map2[j][i] +" ");
//			}
//			System.out.println();
//		}
//		
//		
//	}
	
	
}

class pinBall{
	int x;
	int y;
	int dir;
	int score;
	
	final static int UP = 11;
	final static int DOWN = -11;
	final static int LEFT = 22;
	final static int RIGHT = -22;
	
	public void pinInit(int x,int y,int dir, int score) {
		
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.score = score;
		
	}
	
	public pinBall(int x, int y, int dir,int score) {
	
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.score = score;
	}
	public void pinBallMoving(int[][] map) {
		
		if(this.dir == UP) {			
			this.y = this.y -1;
		}
		else if(this.dir == DOWN) {
			this.y = this.y +1;
			
			
		}
		else if(this.dir == LEFT) {
			this.x = this.x -1;
			
		}
		else if(this.dir == RIGHT) {
			this.x = this.x +1;
		}
	}
	
	
	public int pinBallCheck(int state) {
		
		switch(state) {
		
		case -1:
			return -1;
		case 0:
			break;
		case 1:
			
			this.score++;
			
			if(this.dir == DOWN) {
				this.dir = RIGHT;
			}
			else if(this.dir ==LEFT) {
				this.dir =UP;
			}
			else this.dir = -this.dir;
			break;
		case 2:
			//우하
			this.score++;
			if(this.dir ==LEFT) {
				this.dir = DOWN;
			}
			else if(this.dir == UP) {
				this.dir =RIGHT;
			}
			else this.dir = -this.dir;
			break;
		case 3:
			this.score++;
			if(this.dir ==UP) {
				this.dir =LEFT;
			}
			else if (this.dir ==RIGHT) {
				this.dir =DOWN;
			}
			else this.dir = -this.dir;
			//좌
			break;
		case 4:
			this.score++;
			//좌상
			if(this.dir ==RIGHT) {
				this.dir = UP;
			}
			else if(this.dir == DOWN) {
				this.dir =LEFT;
			}
			else 
				this.dir = -this.dir;
			break;
		case 5:
			this.score++;
			//방향반대
				
			this.dir = -this.dir;
			break;
			
		case 6:
			return 6;
		case 7:
			return 6;
		case 8:
			return 6;
		case 9:
			return 6;
		case 10:
			return 6;
		
		
		}
		return 0;
		
	}
	
	
}

class warmHoll{
	int warmHollNumber = -1;
	coor first = null;
	coor second= null;
	
	
	public void setWarmHollNumber(int a) {
		this.warmHollNumber = a;
	}
	
	public void setWarmHoll(coor a) {
		if(first == null) {
			first = new coor(a.x,a.y);
		}
		else if(second == null) {
			second = new coor(a.x,a.y);
		}
		else
		{
			System.out.println("에러");
		}
		
	}
	
	public coor anotherHoll(coor a) {
		if(first.x == a.x && first.y == a.y)
			return second;
		
		else if( second.x == a.x && second.y == a.y)
			return first;
		
		else {
			
			System.out.println("에러");
		}
		return a;
		
	}
	
	public boolean isAnother(coor a) {
		if(first.x == a.x && first.y == a.y){
			return true;
		}
		else if( second.x == a.x && second.y == a.y) {
			return true;
		}
		return false;
		
	}
	
	
}

class coor{
	int x;
	int y;
	
	public coor(int x, int y) {
	
		this.x = x;
		this.y = y;
	}

	public coor() {
		// TODO Auto-generated constructor stub
	}
	
	
}
