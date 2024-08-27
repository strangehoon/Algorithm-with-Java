import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] graph = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            graph[y][x] = -1;
        }
        graph[1][1] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(graph[i][j]==-1){
                    continue;
                }
                if(graph[i][j-1]!=-1){
                    graph[i][j] += graph[i][j-1];
                    graph[i][j] %= 1000000007;
                }
                if(graph[i-1][j]!=-1){
                    graph[i][j] += graph[i-1][j];
                    graph[i][j] %= 1000000007;
                }
            }
        }
        
        return graph[n][m];
    }
}