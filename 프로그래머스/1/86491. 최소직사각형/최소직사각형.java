import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int result_left = 0;
        int result_right = 0;
        for(int i=0; i<sizes.length; i++){
            int left = Math.max(sizes[i][0], sizes[i][1]);
            int right = Math.min(sizes[i][0], sizes[i][1]);
            result_left = Math.max(left, result_left);
            result_right = Math.max(right, result_right);
        }
        return result_left*result_right;
    }
}