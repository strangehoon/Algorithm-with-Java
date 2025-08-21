import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        
        int a = n;
        int idx = 0;
        int[] answer = new int[n];
        
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<=n; i++){
            nums.add(i);
        }
        
        long[] factorial = new long[n];
        factorial[0] = 1;
        for(int i=1; i<n; i++){
            factorial[i] = factorial[i-1]*i;
        }
        
        while(a-->0){
                
            long x = k/factorial[a];
            k = k%factorial[a];
            
            if(k==0){
                x--;
                
                if(x==-1)
                    x = n-1-idx;
            }
            
            answer[idx++] = nums.get((int)x);
            nums.remove((int)x);
            
        }
        return answer;
    }
}
