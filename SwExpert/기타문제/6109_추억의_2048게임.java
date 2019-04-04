//https://www.swexpertacademy.com/main/code/problem/problemDetail.do

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Solution
{
	static ArrayList<Integer> array = new ArrayList<Integer>();
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		int playbordSize = 0;
		String direction;
		T=sc.nextInt();
		int playboard[][];
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			playbordSize = sc.nextInt();
			direction = sc.next();
			
			 playboard = new int[playbordSize][playbordSize];
			 
			for(int i=0; i<playbordSize; i++) {
				for(int j=0; j<playbordSize; j++)
					playboard[i][j] = sc.nextInt();
				
			}
			 playboard = play(playboard,direction,playbordSize);
			
            System.out.println("#"+test_case);
            print(playboard,playbordSize);
            array.clear();
		}
	}

	public static void print(int[][] board,int boardSize) {
		for(int i=0; i<boardSize; i++) {
			
			for(int j=0; j<boardSize; j++) {
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
			
		}
		
		
	}
	
	public static int[][] play(int[][] board, String direction,int boardSize){
		
		int[] temp = new int[boardSize];
	
		Queue<Integer> st = new LinkedList<Integer>();
		switch(direction) {
				case "up":
					for(int i=0; i<boardSize; i++) {
						
						array.clear();
						for(int j=0; j<boardSize; j++) {
							
							if(board[boardSize-j-1][i] != 0 )
									// 2 4 2 2
									array.add(board[boardSize-j-1][i]);
						
						}
						//2 4 4 
						
							for(int q=array.size()-1; q>0; q--) {
								
								 if(array.get(q) == 0 ) {
									continue;
								}
								 else if(array.get(q).equals(array.get(q-1))) {
										st.add(array.get(q)*2);
										array.set(q-1, 0);
								}
								 
								else if(array.get(q) != array.get(q-1))
									st.add(array.get(q));
							}
							if(array.isEmpty() != true) {
								if(array.get(0) != 0 )
									st.add(array.get(0));
							}
							
						
						// 한줄 완료 
						for(int k= 0 ; k<boardSize; k++) {
							
							 if(st.isEmpty() != true) {
								
								
								board[k][i] = st.poll();
							}
							else
								board[k][i] = 0 ;
						}
					}
					
					break;
					
				case "down":
					
					for(int i=0; i<boardSize; i++) {
						
						array.clear();
						for(int j=0; j<boardSize; j++) {
							
							if(board[j][i] != 0 )
									// 2 4 2 2
									array.add(board[j][i]);
						
						}
						//2 4 4 

						for(int q=array.size()-1; q>0; q--) {
							
							 if(array.get(q) == 0 ) {
								continue;
							}
							 else if(array.get(q).equals(array.get(q-1))) {
									st.add(array.get(q)*2);
									array.set(q-1, 0);
							}
							 
							else if(array.get(q) != array.get(q-1))
								st.add(array.get(q));
						}
						if(array.isEmpty() != true) {
						if(array.get(0) != 0 )
							st.add(array.get(0));
						}
					
						
						// 한줄 완료 
						for(int k= 0 ; k<boardSize; k++) {
							
							 if(st.isEmpty() != true) {
								board[boardSize-1 - k][i] = st.poll();
							}
							else
								board[boardSize-1 - k][i] = 0 ;
						}
					
					}
					break;
				case "left":
					for(int i=0; i<boardSize; i++) {
						
						array.clear();
						for(int j=0; j<boardSize; j++) {
							
							if(board[i][boardSize-1 - j] != 0 )
									// 2 4 2 2
									array.add(board[i][boardSize-1 - j]);
						
						}
						//2 4 4 

						for(int q=array.size()-1; q>0; q--) {
							
							 if(array.get(q) == 0 ) {
								continue;
							}
							 else if(array.get(q).equals(array.get(q-1))) {
									st.add(array.get(q)*2);
									array.set(q-1, 0);
							}
							 
							else if(array.get(q) != array.get(q-1))
								st.add(array.get(q));
						}
						if(array.isEmpty() != true) {
						if(array.get(0) != 0 )
							st.add(array.get(0));
						}
					
					
						// 한줄 완료 
						for(int k= 0 ; k<boardSize; k++) {
							
							 if(st.isEmpty() != true) {
								board[i][k] = st.poll();
							}
							else
								board[i][k] = 0 ;
						}
					}
						
					break;
				case "right":
					for(int i=0; i<boardSize; i++) {
						
						array.clear();
						for(int j=0; j<boardSize; j++) {
							
							if(board[i][j] != 0 )
									// 2 4 2 2
									array.add(board[i][j]);
						
						}
						//2 4 4 

						for(int q=array.size()-1; q>0; q--) {
							
							 if(array.get(q) == 0 ) {
								continue;
							}
							 else if(array.get(q).equals(array.get(q-1))) {
									st.add(array.get(q)*2);
									array.set(q-1, 0);
							}
							 
							else if(array.get(q) != array.get(q-1))
								st.add(array.get(q));
						}
						if(array.isEmpty() != true) {
						if(array.get(0) != 0 )
							st.add(array.get(0));
						}
						
						// 한줄 완료 
						for(int k= 0 ; k<boardSize; k++) {
							
							if(st.isEmpty() != true) {
								board[i][boardSize-1 -k] = st.poll();
							}
							else
								board[i][boardSize-1 - k] = 0 ;
						}
					
					
					}

						
					break;
	}
		return board;


		}
}