//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<house> houseS = new ArrayList<house>();
		int maxHouse =0;
		int tempHouse =0;
	
		
		
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] map = new int[n+1][n+1];
			maxHouse =0;
			tempHouse =0;
			houseS.clear();
			
		
			for(int qy =1; qy<n+1; qy++) {
				for(int qx=1; qx<n+1; qx++) {
					map[qx][qy] = sc.nextInt();
					if(map[qx][qy] ==1 )
						houseS.add(new house(qx,qy));
				}
				
			}
			int k= findMaxK(houseS.size(),m);
			
//			log(map);
			
			for(int qy =1; qy<n+1; qy++) {
				for(int qx=1; qx<n+1; qx++) {
					tempHouse = findHouseNumber(map,qx,qy,k,m,houseS);
					
					if(tempHouse > maxHouse)
						maxHouse = tempHouse;
					
				}
				
			}
			
			
			System.out.println("#"+(i+1)+" "+maxHouse);
			
		}
		
		
		
		
	}
	
	public static int distance(house home,int x,int y) {
		
		int xGap = home.x -x;
		int yGap = home.y -y;
		

		return Math.abs(xGap)+Math.abs(yGap);
	}
	
	public static int findSepcificDistance(int dis,ArrayList<house> houseS,int x,int y) {
		
		int count =0;
		
		for(int i=0; i<houseS.size(); i++) {
			if( distance( houseS.get(i),x,y) ==dis)
			{
				count ++;
			}
		}
		
		
		
		return count;
		
	}
	public static int findMaxHouse(int[] profit, int[] houseNumber) {
		
		
		//이거 뒤로 돌면서 양수일때 리턴해야돼.
		
		for(int i=profit.length-1; i>=0;i--) {
			if(profit[i] >= 0 )
			{
				return listSum(houseNumber,i);
			}
			
		}
	
	
		return 0;
	
	}
	
	
	
	public static int findHouseNumber(int[][] map, int x, int y, int maxK,int m,ArrayList<house> houseS) {
		int[] profit = new int[maxK+1];
		int[] houseNumber= new int[maxK+1];
		
		
		for(int i=0; i<=maxK; i++) {
			houseNumber[i] = findSepcificDistance(i,houseS,x,y);
			profit[i] = m*listSum( houseNumber,i ) -(i*i) - ((i-1)*(i-1));
		}
		
		return findMaxHouse(profit,houseNumber);
	}
		public static int listSum(int[] list, int q) {
		int sum =0;
		
		for(int i=0; i<q;i++) {
			sum += list[i];
			
		}
		
		return sum;
	}
	
	
	public static int findMaxK(int houseSize,int profit) {
		int k=1;
		int panelty =0;
		int total_profit = profit * houseSize;
		while(true) {
			panelty = k*k + (k-1)*(k-1);
			if(total_profit - panelty < 0 )
				break;
			
			
			k++;
			
		}
		
		
		return k-1;
		
		
	}
	
	
	
	
	public static void log(int[][] map) {
		int xSize = map.length;
		int ySize = map[0].length;
		
		for(int i=0; i<ySize; i++) {
			for(int j=0; j<xSize; j++) {
				System.out.print(map[j][i]);
				
			}
			System.out.println();
		}
			
	}
	
	
}


class house{
	int x;
	int y;
	
	public house(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	
	
}