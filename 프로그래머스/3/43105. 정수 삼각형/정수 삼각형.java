import java.util.*;

// 2026/07/13
// 20:35 ~ 21:35
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(0<j && j<i){
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
                else if(j==0){
                    triangle[i][j] += triangle[i-1][j];
                }
                else {
                    triangle[i][j] += triangle[i-1][j-1];
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++){
            answer = Math.max(answer, triangle[n-1][i]);
        }
        return answer;
    }
}
