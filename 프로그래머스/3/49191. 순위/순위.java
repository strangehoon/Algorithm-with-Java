import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] graph = new int[n][n];
        int answer = 0; 
        for(int i=0; i<n; i++){
            graph[i][i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<results.length; i++){
            int a = results[i][0]-1;
            int b = results[i][1]-1;
            graph[a][b] = 1;
            graph[b][a] = -1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(graph[j][i]==1 && graph[i][k]==1){
                        graph[j][k] = 1;
                    }
                    else if(graph[j][i]==-1 && graph[i][k]==-1){
                        graph[j][k] = -1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(graph[i][j]==1 || graph[i][j]==-1){
                    cnt++;
                }
            }
            if(cnt==n-1){
                answer ++;
            }
        }
        
        return answer;
    }
}