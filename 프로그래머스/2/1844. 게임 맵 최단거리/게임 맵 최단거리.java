
import java.util.*;
class Solution {
    
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {1, -1, 0, 0};
    public class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        dist[0][0] = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point.x==n-1 && point.y==m-1){
                return dist[n-1][m-1];
            }
            for(int i=0; i<4; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(maps[nx][ny]==1 && dist[nx][ny]==0){
                        dist[nx][ny] = dist[point.x][point.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }    
        }
        return -1;
    }
}