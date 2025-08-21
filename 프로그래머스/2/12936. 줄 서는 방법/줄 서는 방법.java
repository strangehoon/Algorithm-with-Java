import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        
        int a = n;
        int idx = 0;
        int[] answer = new int[n];
        boolean[] used = new boolean[n+1];
        
        while(a-->0){
            
            long tem = 1;
            for(int i=1; i<=a; i++){
                tem *= i;
            }
                
            long num = k/tem;
            k = k%tem;
            
            if(k==0){
                num = num==-1 ? n-1-idx : num--;
                num--;
                if(num==-1)
                    num = n-1-idx;
            }
  
            for(int i=1; i<=n; i++){
                if(!used[i]){
                    if(num==0){
                        used[i] = true;
                        answer[idx++] = i;
                        break;
                    } 
                    else{
                        num--;
                    }
                }
            }
        }
        return answer;
    }
}