import java.util.*;
class Solution {
    
    public class Pos{
        int x;
        int y;
        
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] dist = new int[101][101];
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(characterX*2, characterY*2));
        dist[characterX*2][characterY*2] = 0;
        
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            
            if(nowX==itemX*2 && nowY==itemY*2){
                return dist[nowX][nowY]/2;
            }
            
            for(int i=0; i<4; i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];
                boolean flag = false;
                
                // 테두리 밖
                if(2>nx || nx>100 || 2>ny || ny>100)
                    continue;
                if(dist[nx][ny]!=Integer.MAX_VALUE)
                    continue;
                
                for(int j=0; j<rectangle.length; j++){
                    int[] rec = rectangle[j];
                    
                    if(nx==rec[0]*2 || nx==rec[2]*2){
                        if(rec[1]*2<=ny && ny<=rec[3]*2){
                            flag = true;
                        }
                    }
                    if(ny==rec[1]*2 || ny==rec[3]*2){
                        if(rec[0]*2<=nx && nx<=rec[2]*2){
                            flag = true;
                        }
                    }
                    // 테두리 내부
                    if(rec[0]*2<nx && nx<rec[2]*2 && rec[1]*2<ny && ny<rec[3]*2){
                        flag = false;
                        break;
                    }
                }
                if(flag==true){
                    queue.offer(new Pos(nx, ny));
                    dist[nx][ny] = dist[nowX][nowY]+1;
                }
            }
        }
        return -1;
    }
}