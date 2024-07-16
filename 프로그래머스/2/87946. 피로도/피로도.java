import java.util.*;
class Solution {
    public int[][] dungeons;
    public int len;
    public boolean[] visited;
    public int result = Integer.MIN_VALUE;
    public void DFS(int energy, int cnt){
        for(int i=0; i<len; i++){
            if(!visited[i] && energy>=dungeons[i][0]){
                visited[i] = true;
                DFS(energy-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
        result = Math.max(result, cnt);
    }
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        len = dungeons.length;
        visited = new boolean[len];
        DFS(k, 0);
        return result;
    }
}