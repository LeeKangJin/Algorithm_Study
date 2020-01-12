import java.util.*;
import java.io.*;
 
class Solution{
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner in=new Scanner(System.in);
        int T;
        T=in.nextInt();
        int Max=100001,max=-1,max_id=0;
        int cnt[] = new int[Max];
         
        for(int i=1;i<Max;i++){
            for(int j=i;j<Max;j+=i){
                cnt[j]++;   
            }
        }
        for(int i=1;i<Max;i++){
            if(cnt[i]>=max){
                max=cnt[i];
                max_id=i;
            }
            cnt[i]=max_id;
        }
         
         
        for(int test_case=1; test_case<=T;test_case++){
           int num;
            num=in.nextInt();
            System.out.println("#"+ test_case+" "+cnt[num]);
        }
         
    }
}
