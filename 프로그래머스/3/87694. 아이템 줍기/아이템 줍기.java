import java.util.*;

class Solution {
    public boolean isLine(int[][] rectangles, int x, int y, int nx, int ny){
        int cnt = 0;
        for(int[] rectangle : rectangles){
            if(rectangle[0]<=x && x<=rectangle[2] && rectangle[0]<=nx && nx<=rectangle[2] && rectangle[1]<=y && y<=rectangle[3] && rectangle[1]<=ny && ny<=rectangle[3]){
                cnt++;
            }
        }
        if(cnt>1)
            return false;
        
        for(int[] rectangle : rectangles){
            if(rectangle[0]==x && rectangle[0]==nx && rectangle[1]<=y && y<=rectangle[3] && rectangle[1]<=ny && ny<=rectangle[3]){
                return true;
            }
            if(rectangle[2]==x && rectangle[2]==nx && rectangle[1]<=y && y<=rectangle[3] && rectangle[1]<=ny && ny<=rectangle[3]){
                return true;
            }
            if(rectangle[1]==y && rectangle[1]==ny && rectangle[0]<=x && x<=rectangle[2] && rectangle[0]<=nx && nx<=rectangle[2]){
                return true;
            }
            if(rectangle[3]==y && rectangle[3]==ny && rectangle[0]<=x && x<=rectangle[2] && rectangle[0]<=nx && nx<=rectangle[2]){
                return true;
            }
        }
        return false;
    }
    
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] dist = new int[51][51];
        for(int i=0; i<51; i++){
            Arrays.fill(dist[i], -1);
        }
        dist[characterX][characterY] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX, characterY});
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==itemX && cur[1]==itemY){
                return dist[cur[0]][cur[1]];
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(0<=nx && nx<51 && 0<=ny && ny<51 && dist[nx][ny]==-1 && isLine(rectangles, cur[0], cur[1], nx, ny)){
                    dist[nx][ny] = dist[cur[0]][cur[1]]+1;
                    queue.offer(new int[]{nx, ny});
                    
                }
            }
        }    
        return -1;
    }
}