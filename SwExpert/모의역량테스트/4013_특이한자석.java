//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	final static int LEFT =-1;
	final static int RIGHT =1;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		int trunNumber;
		T=sc.nextInt();
	
		int[] temp = new int[8];
		elecCircle[] ec =new elecCircle[4];
		int elecNum;
		int trunDirection;
		
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			trunNumber = sc.nextInt();
			
			for(int j=0; j<4; j++) {
				
				
				for(int i=0; i<8; i++) {
				
					temp[i] =  sc.nextInt();
				}
				
				ec[j] = new elecCircle(temp);
				
			}
			
			for(int i=0; i<trunNumber; i++) {
				elecNum = sc.nextInt();
				trunDirection = sc.nextInt();
				
				if(elecNum ==1) {
					
					if(trunDirection == RIGHT)
					{
							if(trunRightCheck(ec[0],ec[1])) {
								
								if(trunRightCheck(ec[1],ec[2])) {
									
									if(trunRightCheck(ec[2],ec[3])) {
										ec[3].Trun(LEFT);
									}
									ec[2].Trun(RIGHT);
								}
								ec[1].Trun(LEFT);
							}
						ec[0].Trun(RIGHT);
					}
				
					else if(trunDirection == LEFT) {
						
						if(trunRightCheck(ec[0],ec[1])) {
							
							if(trunRightCheck(ec[1],ec[2])) {
								
								if(trunRightCheck(ec[2],ec[3])) {
									ec[3].Trun(RIGHT);
								}
								ec[2].Trun(LEFT);
							}
							ec[1].Trun(RIGHT);
						}
					ec[0].Trun(LEFT);
						
						
					}
				
				}
				else if(elecNum ==2) {
					if(trunDirection ==RIGHT) {
						
						if(trunLeftCheck(ec[1],ec[0])) {	
							ec[0].Trun(LEFT);
						}
						if(trunRightCheck(ec[1],ec[2])) {
							if(trunRightCheck(ec[2],ec[3])) {
								ec[3].Trun(RIGHT);	
							}
							ec[2].Trun(LEFT);
						}
					ec[1].Trun(RIGHT);
					}
					
					else if(trunDirection ==LEFT) {
						
						if(trunLeftCheck(ec[1],ec[0])) {	
							ec[0].Trun(RIGHT);
						}
						if(trunRightCheck(ec[1],ec[2])) {
							if(trunRightCheck(ec[2],ec[3])) {
								ec[3].Trun(LEFT);	
							}
							ec[2].Trun(RIGHT);
						}
					ec[1].Trun(LEFT);
						
						
						
					}
					
					
				}
				else if(elecNum ==3) {
					if(trunDirection ==RIGHT) {
						if(trunRightCheck(ec[2],ec[3])) {ec[3].Trun(LEFT);}
						
						if(trunLeftCheck(ec[2],ec[1])) { 
							
							if(trunLeftCheck(ec[1],ec[0])) {ec[0].Trun(RIGHT);}
							
							ec[1].Trun(LEFT);
						}
						
						ec[2].Trun(RIGHT);
					}
					
					else if(trunDirection ==LEFT) {
						if(trunRightCheck(ec[2],ec[3])) {ec[3].Trun(RIGHT);}
						
						if(trunLeftCheck(ec[2],ec[1])) { 
							
							if(trunLeftCheck(ec[1],ec[0])) {ec[0].Trun(LEFT);}
							
							ec[1].Trun(RIGHT);
						}
						
						ec[2].Trun(LEFT);
						
						
					}
					
				}
				else if(elecNum ==4) {
					if(trunDirection ==RIGHT) {
						
						if(trunLeftCheck(ec[3],ec[2])) {
							
							if(trunLeftCheck(ec[2],ec[1])) {
								
								if(trunLeftCheck(ec[1],ec[0])) {
									ec[0].Trun(LEFT);
								}
								ec[1].Trun(RIGHT);
							}
							ec[2].Trun(LEFT);
						}
					ec[3].Trun(RIGHT);
						
						
						
					}
					
					else if(trunDirection ==LEFT) {
					
						if(trunLeftCheck(ec[3],ec[2])) {
							
							if(trunLeftCheck(ec[2],ec[1])) {
								
								if(trunLeftCheck(ec[1],ec[0])) {
									ec[0].Trun(RIGHT);
								}
								ec[1].Trun(LEFT);
							}
							ec[2].Trun(RIGHT);
						}
					ec[3].Trun(LEFT);
						
					}
				}
				
			}
		
		
			System.out.println("#"+test_case+" "+finalScore(ec));
		}
	}

	public static boolean trunRightCheck(elecCircle trunEC,elecCircle checkEC) {
		
		if( trunEC.getRightContact() != checkEC.getLeftContact())
			return true;
		
		else
			return false;
		
	}

	public static boolean trunLeftCheck(elecCircle trunEC,elecCircle checkEC) {
		
		if( trunEC.getLeftContact() != checkEC.getRightContact())
			return true;
		
		else
			return false;
		
	}
	public static int finalScore(elecCircle[] ec) {
		int finalResult=0;
		
		finalResult += ec[0].getElec() *1;
		finalResult += ec[1].getElec() *2;
		finalResult += ec[2].getElec() *4;
		finalResult += ec[3].getElec() *8;
		
		return finalResult;
	}
	
	

}




class elecCircle
{
	// 0은 N, 1은 S
	int[] elecs;;
	int point;
	
	elecCircle(int[] temp) {
		this.elecs = temp.clone();
		this.point = 0;
	
	}
	
	public void Trun(int LeftOrRight) {
		if(LeftOrRight == 1) {
			this.rightTrun();
		}
		else if(LeftOrRight == -1) {
			this.leftTurn();
		}
	}
	
	
	public void rightTrun() { // 시계방향, 인풋 1일때
		
		if(point > 0 ) {
			point--;
			
		}
		else if(point == 0) {
			point = 7;
			
		}
		else {
			System.out.println("에러임2");
		}
		
		
	}
	
	public void leftTurn() { // 반시계 방향, 인풋 -1일 때 
		
		if(point < 7) {
			point++;
		}
		else if(point == 7)
		{
			point = 0;
		}
		else {
			System.out.println("에러임1");
		}
		
	}
	
	//point +2 는 오른쪽 접면
	//point -2는 왼쪽 접면
	
	public int getElec() {
		return this.elecs[this.getPoint()];
	}
	
	public int getPoint() {
		return this.point;
	}
	
	public int getRightContact() {
		int index;
		
		if(point+2 > 7) {
			index = point+2-8;
		}
		else
			index =point+2;
		
		return elecs[index];
	}
	
	public int getLeftContact() {
		int index;
		
		if(point-2 < 0) {
			index = point-2+8;
		}
		else 
			index = point-2;
		
		return elecs[index];
	}
	

}