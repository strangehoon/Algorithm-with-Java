import java.util.*;
// 2026-02-11
// 11:30 ~ 11:40
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length;
        for(int i=0; i<len; i++){
            answer += A[i]*B[len-1-i];
        }
    
        return answer;
    }
}