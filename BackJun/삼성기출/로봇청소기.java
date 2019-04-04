// https://www.acmicpc.net/problem/14503


import java.util.Scanner;

public class Main {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};	
	//좌 하 우  순 으로 (현재 로봇의 방향에서)
	
	//현재 로봇의 위치 2 <->0, 3 <-> 1
	
	static final int LEFT = 3;
	static final int DOWN =2;
	static final int RIGHT =1;
	static final int UP = 0;
	static  int g;
	static  int s;
	
	//0  -1 -> 3, -1위치를 봄 
	public static void main(String[] args) {
	
		Scanner sc =new Scanner(System.in);
		
		int t_t=0;
		int sero = sc.nextInt();
		int garo = sc.nextInt();
		
		g = garo;
		s = sero;
		
		int[][] map = new int[garo][sero];
		
		int robotY = sc.nextInt();
		int robotX = sc.nextInt();
		int robotDir = sc.nextInt();
		
		Robot robot = new Robot(robotDir,robotX,robotY);
		
		
		for(int i=0 ;i<sero;i++) {
			for(int j=0; j<garo; j++) {
				map[j][i] = sc.nextInt();
			}
		}
		
		while(true) {
			
			int x = robot.x;
			int y = robot.y;
			int d = robot.dir;
			
			//청소 실행 
			map[x][y] = 2;
			
			
			if( !allDirCheck(robot,map)) {//청소할게 없다
				int tempd= d;
				//후진해보자
				if(d == UP ) d=DOWN;
				else if(d == DOWN ) d=UP;
				else if (d== LEFT ) d= RIGHT;
				else if (d== RIGHT ) d= LEFT;
				
				robot.dir = d;
				robot.robotMove(dx, dy);
				
				//벽이면 
				if(map[robot.x][robot.y] == 1) {
					break;
				}
				else { 
					robot.dir = tempd;
					continue;
				}
			}
			
			
			while(true) {
			
			   if(checkLeft(robot,map,dx,dy)) {
				robot.robotDirChange();
				robot.robotMove(dx, dy);
				break;
			}
			else 
				robot.robotDirChange();
			
			}
		}
		
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				if( map[j][i] ==2) t_t++;
			}
		}
		
		System.out.println(t_t);
	}
	public static boolean allDirCheck(Robot robot, int[][] map) {
		
		int x = robot.x;
		int y=  robot.y;
		int count =0;
		
		for(int i=3; i>=0; i--) {
			if(x+dx[i] < 0 || x+dx[i] >=g || y+dy[i] <0 || y+dy[i]>=s)
				continue;
			else if( map[x+dx[i]][y+dy[i]] == 0)
				count =1;
		}
		if(count ==1) //아직 청소할게 있다.
			return true;
		else	
			return false;
	}
	
	public static boolean checkLeft(Robot robot,int[][] map,int[] dx, int[] dy)
	{
		int c;
		int d = robot.dir;
		int x= robot.x;
		int y= robot.y;

		if(d ==UP) {
			if(map[x-1][y] == 0)
				return true;
		}
		if(d ==LEFT) {
			if(map[x][y+1] == 0)
				return true;
		}
		if(d ==DOWN) {
			if(map[x+1][y] == 0)
				return true;
		}
		if(d ==RIGHT) {
			if(map[x][y-1] == 0)
				return true;
		}		
		
		return false;
		
		
	}
	
}


class Robot{
	int dir;
	int x; 
	int y;
	
	public Robot(int dir, int x, int y) {
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
	
	public void robotMove(int[] dx, int[] dy) {
		this.x = this.x +dx[this.dir];
		this.y = this.y +dy[this.dir];
		
	}
	
	public void robotDirChange() {
		if(dir == 0) {this.dir = 3;}
		
		else {
			this.dir = this.dir -1;
		}
		
	}
	
	
}