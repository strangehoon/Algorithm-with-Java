import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        
        int width = 0;
        int length = 0;
        for(int[] size : sizes){
            int sh = Math.min(size[0], size[1]);
            int lo = Math.max(size[0], size[1]);
            
            width = Math.max(lo, width);
            length = Math.max(sh, length);
        }
        
        return width*length;
    }
}

