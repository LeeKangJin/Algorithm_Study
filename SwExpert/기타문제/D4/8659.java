import java.util.ArrayList;
import java.util.Scanner;

public class Solution {   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int i=1;
      ArrayList<Long> sosu = new ArrayList<>();
      sosu.add((long)1);
      sosu.add((long)2);
      while(sosu.size()<92) {
         sosu.add(sosu.get(i)+sosu.get(i-1));
            i++;
        }
      int allCase = sc.nextInt();
      int val;
      for(int testCase = 1;testCase<=allCase;testCase++) {
         val = sc.nextInt();
         System.out.format("#%d %d %d\n",testCase,sosu.get(val),sosu.get(val-1));
      }
      
   }
   
}
