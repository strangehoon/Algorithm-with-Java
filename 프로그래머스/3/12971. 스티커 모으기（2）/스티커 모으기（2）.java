import java.util.*;
// 2026-02-09
// 10:40 ~ 11:16
class Solution {
    public int solution(int sticker[]) {
        
        int len = sticker.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        
        if(len==1){
            return sticker[0];
        }
        
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        
        for(int i=2; i<len-1; i++){
            dp1[i] = Math.max(sticker[i]+dp1[i-2], dp1[i-1]);
        }
        
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for(int i=2; i<len; i++){
            dp2[i] = Math.max(sticker[i]+dp2[i-2], dp2[i-1]);
        }
        
        return Math.max(dp1[len-2], dp2[len-1]);
    }
}
