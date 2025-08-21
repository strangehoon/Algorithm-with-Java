import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        
        int a = n;
        long b = k;
        int idx = 0;
        int[] answer = new int[n];
        boolean[] used = new boolean[n+1];
        
        while(a-->0){

            long tem = 1;
            for(int i=1; i<=a; i++){
                tem *= i;
            }
                
            long num = b/tem;
            long na = b%tem;
            
            if(na==0){
                num = num-1;
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
            b = na;
        }
        return answer;
    }
}

// 4 16
// 3 2 4
// 2 2 0
// 1 0 0
    
// 3 2 4 1  

// 4  17
// 3  2, 5
// 2  2, 1    
// 1  1, 0

// 3 4 1 2

// 4 18
// 3 3 0
// 2 0 0

// 3 4 2 1 
    
// 4 19 
// 3 3 1
// 2 0 1
// 1 1 0 
    
// 4 1 2 3
    
// 4 20
// 3 3 2
// 2 1 0

// 4 
    

// 1 2 3 4 
// 1 2 4 3
// 1 3 2 4
// 1 3 4 2
// 1 4 2 3
// 1 4 3 2
// 2 1 3 4
// 2 1 4 3
// 2 3 1 4
// 2 3 4 1
// 2 4 1 3
// 2 4 3 1
// 3 1 2 4
// 3 1 4 2
// 3 2 1 4
// 3 2 4 1
// 3 4 1 2
// 3 4 2 1
// 4 1 2 3
// 4 1 3 2
// 4 2 1 3
// 4 2 3 1
// 4 3 1 2
// 4 3 2 1

    
    
// 2 2 1
// 1 1 0 
    
    
// 3 