//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	// K 300
	
	// M ,N 50 임으로 최대 배열 350~400 정도 선 잡으면 된다.
	
	final static int MAX_INDEX = 500;
	final static int START_INDEX= 200;
	// 0: 공백 1 : 비활성 , 2 : 활성 , 3 : 사망
	
	final static int SPACE =0;
	final static int NONACT = 1;
	final static int ACTIVE = 2;
	final static int DEATH = 3;
	
	
	final static int EMER =4;
	final static int DYING= 5;
	static ArrayList<cell> cellList = new ArrayList<cell>();
	static ArrayList<cell> tempList = new ArrayList<cell>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int z= 0; z<t; z++) {
			int sero= sc.nextInt();
			int garo= sc.nextInt();
			int sol_time= sc.nextInt();
			
			int temp =0 ;
			cell[][] map = new cell[garo][sero];
			cell[][] virture_map = new cell[MAX_INDEX][MAX_INDEX];
			cellList.clear();
			tempList.clear();
			
			for(int i=0; i<sero; i++) {
				for(int j=0; j<garo; j++) {
					
					temp = sc.nextInt();
				
					if(temp != 0) {
						map[j][i] = new cell(j,i,1,temp);
						cellList.add(new cell(j+START_INDEX,i+START_INDEX,1,temp));
					}
					
					else
						map[j][i] = new cell(j,i,temp,temp);
					
				}
				
			}
			
			for(int i=0; i<MAX_INDEX; i++) {
				for(int j=0; j<MAX_INDEX; j++) {
					virture_map[j][i] = new cell(j,i,0,0);
				}
				
			}
			
			for(int i = START_INDEX; i< (START_INDEX+sero); i++){
				for(int j= START_INDEX; j< (START_INDEX+garo); j++) {
					virture_map[j][i] = map[j-START_INDEX][i-START_INDEX];
//					System.out.print(virture_map[j][i].power);
					
				}
//				System.out.println();
				
			}
			// for k 시간 만큼
			for(int i=0; i<sol_time; i++) {
			// 셀리스트를 돌면서 활성 상태인 친구들 움직임.
			// 활성아니면 안움직임
			// 셀리스트 애들 시간도 하나씩 추가
			virture_map = cellMoving(cellList,virture_map);
			
		
			// 모든 셀들 시간 확인해보고 stage 변경
			// 죽었으면 사망 처리 
				for(int j=0; j<cellList.size(); j++) {
					
					cellList.get(j).stateChage();
					
					int xpoint = cellList.get(j).x;
					int ypoint = cellList.get(j).y;
					int spoint = cellList.get(j).state;
					
					virture_map[xpoint][ypoint].state = spoint;
					
					if(cellList.get(j).state == DEATH) {
						continue;
					}
					else 
						tempList.add(cellList.get(j));
					
				}
				cellList = (ArrayList<cell>) tempList.clone();
				tempList.clear();
				
//				System.out.println("time"+(i+1));
//				mapLog(195,205, virture_map);
			}
			
			
			System.out.println("#"+(z+1)+" "+cellList.size());
		}
	}

	public static void mapLog(int start, int end,cell[][] virture_map) {
		
		for(int i=start; i<end; i++) {
			for(int j=start; j<end; j++) {
				
				if(virture_map[j][i].state ==DEATH) {
					System.out.print("  ");
					
				}
				else
					System.out.print(virture_map[j][i].power+" ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	public static cell[][] cellMoving(ArrayList<cell> cellList, cell[][] virture_map){
		
		Queue<cell> temp_q = new LinkedList<cell>();
		
	for(int i=0; i<cellList.size(); i++) {	
				//상 하 좌 우 체 크 
				int x = cellList.get(i).x;
				int y = cellList.get(i).y;
				
				cell befo_t = virture_map[x][y];
			
				cell up_t = virture_map[x][y-1];
				cell down_t = virture_map[x][y+1];
				cell left_t = virture_map[x-1][y];
				cell right_t = virture_map[x+1][y];
			
				
				if(befo_t.state == ACTIVE) {
				
			
					
					if(up_t.state == DEATH) {
						//
					}
					else if(up_t.state == NONACT) {
						//
					}
					else if(up_t.state == SPACE) {
						up_t.state = EMER;
						up_t.power = befo_t.power;
					}
					else if(up_t.state == EMER) {
						if(befo_t.power > up_t.power)
							up_t.power = befo_t.power;
						
					}
				
					
					if(down_t.state == DEATH) {
						//
					}
					else if(down_t.state == NONACT) {
						//
					}
					else if(down_t.state == SPACE) {
						down_t.state = EMER;
						down_t.power = befo_t.power;
					}
					else if(down_t.state == EMER) {
						if(befo_t.power > down_t.power)
							down_t.power = befo_t.power;
						
					}
				
					
					
					if(left_t.state == DEATH) {
						//
					}
					else if(left_t.state == NONACT) {
						//
					}
					else if(left_t.state == SPACE) {
						left_t.state = EMER;
						left_t.power = befo_t.power;
					}
					else if(left_t.state ==EMER) {
						if(befo_t.power > left_t.power)
							left_t.power = befo_t.power;
						
					}
					
					
					if(right_t.state == DEATH) {
						//
					}
					else if(right_t.state == NONACT) {
						//
					}
					else if(right_t.state == SPACE) {
						right_t.state = EMER;
						right_t.power = befo_t.power;
					}
					else if(right_t.state ==EMER) {
						if(befo_t.power > right_t.power)
							right_t.power = befo_t.power;
						
					}
				}
				
//				  virture_map[x][y-1] =up_t;
//				   virture_map[x][y+1] = down_t;
//				   virture_map[x-1][y] = left_t;
//				   virture_map[x+1][y] = right_t;
//				
				
				cellList.get(i).addTime();
				if(befo_t.state ==ACTIVE) {
					befo_t.state = DYING;
				
				}
			}
	
	
		
		
		for(int i=0; i<cellList.size(); i++) {
			int x = cellList.get(i).x;
			int y = cellList.get(i).y;
			
			cell befo_t = virture_map[x][y];
		
			cell up_t = virture_map[x][y-1];
			cell down_t = virture_map[x][y+1];
			cell left_t = virture_map[x-1][y];
			cell right_t = virture_map[x+1][y];
			
			
			
			if( up_t.state == EMER ) {
				up_t.state = NONACT;
				temp_q.add(new cell(x,y-1,1,virture_map[x][y-1].power));
			
			}
			if( down_t.state == EMER ) {
				down_t.state = NONACT;
				temp_q.add(new cell(x,y+1,1,virture_map[x][y+1].power));
			}
			if( left_t.state == EMER ) {
				left_t.state = NONACT;
				temp_q.add(new cell(x-1,y,1,virture_map[x-1][y].power));
			}
			if( right_t.state == EMER ) {
				right_t.state = NONACT;
				temp_q.add(new cell(x+1,y,1,virture_map[x+1][y].power));
			}
			
			
		}
		
		while(!temp_q.isEmpty()) {
			cellList.add(temp_q.poll());
		}
	
	
//		//일단 급한데로 배열 쫙 찾는데 안되면 다른 방법 ㄱㄱ
//		
//		for(int i=0; i<MAX_INDEX; i++) {
//			for(int j=0; j<MAX_INDEX; j++) {
//				
//				if( virture_map[j][i].state == EMER) {
//					virture_map[j][i].state = NONACT;
//					cellList.add(new cell(j,i,1,virture_map[j][i].power));
//				}
//			}
//			
//		}
		
		
		
		
		return virture_map;
	}
	
	
}


class cell{
	int x;
	int y;
	int state; // 0: 공백 1 : 비활성 , 2 : 활성 , 3 : 사망 , 4: 비상 5 : 죽음 대기 상
	int power;
	int time;
	
	public cell(int x, int y, int state, int power) {

		this.x = x;
		this.y = y;
		this.state = state;
		this.power = power;
		this.time = 0;
	}
	
	public void stateChage() {
		if(time <power)
			this.state =1;
		else if(time >= power && time < (power*2))
			 this.state = 2;
		else if(time >= (power*2))
			this.state = 3;
	}
	
	public void addTime() {
		this.time = this.time+1;
	}
	
	
	
	
}
