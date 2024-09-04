import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        
        if(sticker.length==1){
            return sticker[0];
        }
        
        if(sticker.length==2){
            return Math.max(sticker[0], sticker[1]);
        }
        
        dp1[0] = sticker[0];
        dp1[1] = sticker[1];
        dp1[2] = dp1[0] + sticker[2];
        
        dp2[0] = 0;
        dp2[1] = sticker[1];
        dp2[2] = sticker[2];
        
        for(int i=3; i<sticker.length; i++){
            dp1[i] = sticker[i];
            dp2[i] = sticker[i];
            
            dp1[i] += Math.max(dp1[i-2], dp1[i-3]);
            dp2[i] += Math.max(dp2[i-2], dp2[i-3]);
        }
        
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<sticker.length; i++){
            max_value = Math.max(dp2[i], max_value);
            if(i!=sticker.length-1)
                max_value = Math.max(dp1[i], max_value);
        }
    
        return max_value;
    }
}