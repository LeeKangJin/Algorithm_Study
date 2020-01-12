import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String input = sc.next();
             
            int cnt = 0;
            int sum = input.charAt(0)-'0';
            for(int i = 1; i<input.length(); i++) {
                sum += input.charAt(i)-'0';
                cnt++;
                if(sum >=10) {
                    sum = sum/10 + sum%10;
                    cnt++;
                }
            }
            if(cnt %2 == 0) {
                System.out.println("#" + test_case + " B");
            }else {
                System.out.println("#" + test_case + " A");
            }
        }
        sc.close();
    }
}
