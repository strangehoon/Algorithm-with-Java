import java.util.*;
class Solution {
    // 동, 남, 서, 북
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};

    public class Point{
        int x;
        int y;
        int cost;
        int dir;
        public Point(int x, int y, int cost, int dir){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
 
    public int solution(int[][] board) {
        int[][][] distance = new int[board.length][board[0].length][2];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                for(int k=0; k<2; k++)
                    distance[i][j][k] = Integer.MAX_VALUE;
            }
        }
        distance[0][0][0] = 0;
        distance[0][0][1] = 0;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0, 0));
        queue.offer(new Point(0, 0, 0, 1));
        
        int result = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowCost = now.cost;
            int dir = now.dir;
            
            if(nowX==board.length-1 && nowY==board[0].length-1){
                result = Math.min(nowCost, result);
            }
            
            if(distance[nowX][nowY][dir]<nowCost){
                continue;
            }
            
            for(int i=0; i<4; i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];
                int nd = 100;
                if(dir!=(i%2)){
                    nd += 500;
                }
                if(0<=nx && nx<board.length && 0<=ny && ny<board[0].length && board[nx][ny]==0){
                    if(distance[nx][ny][i%2]>nowCost+nd){
                        distance[nx][ny][i%2]=nowCost+nd;
                        queue.offer(new Point(nx, ny, nowCost+nd, i%2));
                    }
                }
            }
        }
        
        return result;
    }
}
