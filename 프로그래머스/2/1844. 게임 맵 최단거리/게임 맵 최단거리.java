import java.util.*;
class Solution {
    public int[][] maps;
    public int n, m;
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {1, -1, 0, 0};
    public class Point {
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        int[][]visited = new int[n][m];
        visited[x][y] = 1;
        while(!queue.isEmpty()){
            Point temPt = queue.poll();
            if(temPt.x == n-1 && temPt.y == m-1){
                return visited[temPt.x][temPt.y];
            }
            for(int i=0; i<4; i++){
                int nx = dx[i] + temPt.x;
                int ny = dy[i] + temPt.y;
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(maps[nx][ny]==1 && visited[nx][ny]==0){
                        visited[nx][ny] = visited[temPt.x][temPt.y] +1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }    
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        return BFS(0, 0);
    }
}