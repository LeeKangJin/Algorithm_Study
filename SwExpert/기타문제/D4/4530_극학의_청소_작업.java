import java.util.Scanner;

class Solution
{
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int T;
      T=sc.nextInt();
      long start;
      long end;
      String a;
      count_floor startFloor;
      count_floor endFloor;
      for(int test_case = 1; test_case <= T; test_case++)
      {
         start = sc.nextLong();
         end = sc.nextLong();
         startFloor = new count_floor(start);
         endFloor = new count_floor(end);
         System.out.print("#");
         System.out.print(test_case);
         System.out.print(" ");
         if(endFloor.returnGround() == startFloor.returnGround()) 
            System.out.println(endFloor.calFloor()-startFloor.calFloor());
         
         else
            System.out.println(endFloor.calFloor()-startFloor.calFloor()-1);
         
      }
   }
   
}
class count_floor{
   long floor;
   boolean ground;
   int numberOfDigits;
   count_floor(long floor){
      if(floor>0) {
         this.floor = floor;
         this.ground = true;
      }
      else {
         this.floor = -floor;
         this.ground = false;
      }
      
      String str = String.valueOf(this.floor);
      
      numberOfDigits = str.length();
   }
   boolean returnGround() {
      return ground;
   }
   
   long calFloor() {
      long val = 0;
      long i=1;
      long thisFloor = floor;
      long order;
      while(true) {
         
         order = thisFloor%10;
         if(order>3) order = order-1;
         val = val + order * i;
         i = i * 9;
         if(thisFloor<10)break;
         else thisFloor = thisFloor/10;
      }
      if(ground) return val;
      else return -val;
   }
}
