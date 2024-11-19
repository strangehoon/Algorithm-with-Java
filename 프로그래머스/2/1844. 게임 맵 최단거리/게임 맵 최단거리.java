import java.util.*;

class Pos{
    int x;
    int y;
    int d;
    
    public Pos(int x, int y, int d){
        this.x = x;
        this. y = y;
        this.d = d;
    }
}

class Solution {
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] maps;
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        this.visited = new boolean[maps.length][maps[0].length];
        
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Pos nowPos = queue.poll();
            int nowX = nowPos.x;
            int nowY = nowPos.y;
            int nowD = nowPos.d;
            
            if(nowX==maps.length-1 && nowY==maps[0].length-1){
                return nowD;
            }
            
            
            for(int i=0; i<4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(0<=nx && nx<maps.length && 0<=ny && ny<maps[0].length){
                    if(maps[nx][ny]==1 && visited[nx][ny]==false){
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny, nowD+1));
                    }    
                }    
            }
        }
        
        return -1;
    }
}