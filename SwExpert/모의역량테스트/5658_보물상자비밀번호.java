//https://www.swexpertacademy.com/main/solvingProblem/solvingProblem.do

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer> possibleList = new ArrayList<Integer>();
		int max = 0;
		int maxindex =0;
		
		for(int z= 0; z<t; z++) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			String inputNumber = sc.next();
			possibleList.clear();
			
			int oneLineSize = inputNumber.length()/4;
			
			//  rotation.
			for(int i=0; i<oneLineSize; i++) {
				possibleList =  rotation(possibleList,i,inputNumber);
			}
	
			//최고인 값 k-1개만큼 뽑고 없애버
			for(int i=0; i<(k-1); i++) {
				
				maxindex =Collections.max(possibleList);
				maxindex = possibleList.indexOf(maxindex);
				possibleList.remove(maxindex);
				
			}
			
			// 남은 최고인값
			max = Collections.max(possibleList);
			
			
			System.out.println("#"+(z+1)+" "+max);
		}

		
		
		
	}

	public static int changeToHex(String inputNumber, int start) {
		
		int oneLine = inputNumber.length()/4;
		
		String temp="";

		for(int i=0; i<oneLine; i++) {
			
			temp += inputNumber.substring(start+i,start+i+1);
		}
		return Integer.parseInt(temp,16);
		
	}
	
	public static int lastNumberCheck(int inputNumber, int indexSize) {
		
		if(inputNumber > indexSize) {
			inputNumber -= indexSize;
		}
		return inputNumber;
	}
	
	public static int lastNumber(String inputString, int rotationNumber) {
		
		int lastLenth = inputString.length();
		int oneLineSize = inputString.length()/4;
		
		String lastString ="";
		int temp;
		for(int i=oneLineSize-1; i>=0; i--) {
			temp = lastLenth - i + rotationNumber;
			temp  = lastNumberCheck(temp,lastLenth);
			lastString += inputString.substring(temp-1, temp);
		}
		
		return Integer.parseInt(lastString,16);
		 
		
	}
	
	public static ArrayList<Integer> rotation(ArrayList<Integer> pl,int rotationNumber,String inputNumber){
		
		int lastIndex = inputNumber.length();
		int oneLineSize = lastIndex/4;
		int result = 0;
		int checkvalue = -1;
		
			for(int i=0; i<3; i++) {
		
//				if(rotationNumber ==2 && i ==2) {
//					System.out.println();
//				}
				
				result = changeToHex(inputNumber,i*oneLineSize+rotationNumber);
				
			
				
				checkvalue= pl.indexOf(result);
				
				if(checkvalue == -1 )
					pl.add(result);
				
			
			}
		
		lastIndex = lastNumber(inputNumber,rotationNumber);
		
		checkvalue = 0;
		
		checkvalue = pl.indexOf(lastIndex);
	
		
		if(checkvalue == -1)
			pl.add(lastIndex);

		return pl;
	}

}

