#include <stdio.h>
int main(void)
{
   int test_case;
   int T;
    long long length,min,max,answer;
   scanf("%d", &T);
   
   for (test_case = 1; test_case <= T; ++test_case)
   {
      scanf("%lld", &length);
        if(length == 0 ){
            printf("#%d %lld\n",test_case,0);
            continue;
        }
      scanf("%lld", &min);
      scanf("%lld",&max);
        if(length == 1 && min != max ){
            printf("#%d %lld\n",test_case,0);
            continue;
        }
        if(min > max ){
            printf("#%d %lld\n",test_case,0);
            continue;
        }
        if(min == max ){
            printf("#%d %lld\n",test_case,1);
            continue;
        }
      answer = (max-min)*(length-2)+1;
      printf("#%d %lld\n",test_case,answer);
   }
   return 0; //정상종료시 반드시 0을 리턴해야 합니다.
}
