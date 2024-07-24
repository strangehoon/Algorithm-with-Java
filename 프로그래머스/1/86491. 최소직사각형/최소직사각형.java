import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int width = Integer.MIN_VALUE;
        int length = Integer.MIN_VALUE;
        for(int i=0; i<sizes.length; i++){
            int tem_max = Math.max(sizes[i][0], sizes[i][1]);
            int tem_min = Math.min(sizes[i][0], sizes[i][1]);
            width = Math.max(tem_max, width);
            length = Math.max(tem_min, length);
        }
        return width*length;
    }
}