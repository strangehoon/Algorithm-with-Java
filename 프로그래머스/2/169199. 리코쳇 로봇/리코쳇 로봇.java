import java.util.*;

class Solution {
    // 16:05
    // 17:00
    // bfs 최단거리 
    public class Pos{
        int x;
        int y;
        
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] board) {
        
        int length = board.length;
        int wide = board[0].length();
        char[][] graph = new char[length][wide];
        Pos start = null;
        Pos end = null;
        
        for(int i=0; i<length; i++){
            for(int j=0; j<wide; j++){
                graph[i][j] = board[i].charAt(j);
                if(graph[i][j]=='R')
                    start = new Pos(i, j);
                else if(graph[i][j]=='G')
                    end = new Pos(i, j);
            }
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        int[][] distance = new int[length][wide];
        for(int i=0; i<length; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[start.x][start.y] = 0;
        
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                boolean flag = false;
                
                while(0<=nx && nx<length && 0<=ny && ny<wide && graph[nx][ny]!='D'){
                    flag = true;
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                
                if(flag && distance[nx][ny] > distance[now.x][now.y] +1){
                    distance[nx][ny] = distance[now.x][now.y] + 1;
                    queue.offer(new Pos(nx, ny));
                }
            }
            
        }
        for(int i=0; i<length; i++){
            for(int j=0; j<wide; j++){
                if(distance[i][j]==Integer.MAX_VALUE){
                    distance[i][j] = -1;
                }
            
                //System.out.print(distance[i][j]+" ");
            }
            //System.out.println();
        }
                
        return distance[end.x][end.y];
    }
}