import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        dist[0][0] = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==n-1 && cur[1]==m-1)
                return dist[cur[0]][cur[1]];
            
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(0<=nx && nx<n && 0<=ny && ny<m && maps[nx][ny]==1 && dist[nx][ny]==0){
                    dist[nx][ny] = dist[cur[0]][cur[1]]+1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}