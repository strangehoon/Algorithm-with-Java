import java.util.*;

class Solution {
    // 4:40
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n][n];
        final int INF = 1000000000;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j)
                    graph[i][j] = INF;
            }
        }
        
        for(int[] fare : fares){
            graph[fare[0]-1][fare[1]-1] = Math.min(graph[fare[0]-1][fare[1]-1], fare[2]);
            graph[fare[1]-1][fare[0]-1] = Math.min(graph[fare[1]-1][fare[0]-1], fare[2]);
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }
        
        int minValue = INF;
        int minIdx = -1;
        for(int i=0; i<n; i++){
            int tem = 0;
            boolean flag = true;
            for(int j=0; j<n; j++){
                if(j==s-1 || j==a-1 || j==b-1){
                    if(graph[i][j]==INF){
                        flag = false;
                        break;
                    }
                    tem += graph[i][j];
                }
            }
            if(flag && tem<minValue){
                minIdx = i;
                minValue = tem;
            }
        }
    
        int answer = graph[minIdx][s-1] + graph[minIdx][a-1] + graph[minIdx][b-1];
        
        return answer;
    }
}