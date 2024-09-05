import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 1;
        while(true){
            if(a%2==1){
                a = (a+1)/2;
            }
            else{
                a = a/2;
            }
            if(b%2==1){
                b = (b+1)/2;
            }
            else{
                b = b/2;
            }
            if(a==b){
                return cnt;
            }
            else{
                cnt++;
            }
        }
    }
}