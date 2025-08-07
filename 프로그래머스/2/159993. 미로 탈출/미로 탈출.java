import java.util.*;
class Solution {
    
    public class Pos{
        int x;
        int y;
        int d;
        public Pos(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public int bfs(Pos start, Pos end, char[][] graph){
        
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            if(cur.x == end.x && cur.y == end.y){
                return cur.d;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(0<= nx && nx<graph.length && 0<=ny && ny<graph[0].length && !visited[nx][ny] && graph[nx][ny]!='X'){
                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny, cur.d+1));
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        
        char[][] graph = new char[maps.length][maps[0].length()];
        Pos start = null;
        Pos lever = null;
        Pos end = null;
        for(int i=0; i<maps.length; i++){
            String str = maps[i];
            for(int j=0; j<str.length(); j++){
                graph[i][j] = str.charAt(j);
                if(graph[i][j]=='S'){
                    start = new Pos(i, j, 0);     
                }
                else if(graph[i][j]=='E'){
                    end = new Pos(i, j, 0);
                }
                else if(graph[i][j]=='L'){
                    lever = new Pos(i, j, 0);
                }
            }
        }
        
        int answer = 0;
        int findLever = bfs(start, lever, graph);
        if(findLever==-1){
            return -1;
        }
        else{
            answer += findLever;
            int findEnd = bfs(lever, end, graph);
            if(findEnd ==-1){
                return -1;
            }
            else{
                answer += findEnd;
            }
        }
        
        return answer;
    }
}