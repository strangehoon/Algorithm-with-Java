import java.util.*;
// 10:45
class Solution {
    public int solution(int[] arr) {
        int idx = 1;
        while(true){
            boolean flag = true;
            for(int x : arr){
                if(idx%x!=0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
            idx++;
        }        
        return idx;
    }
}