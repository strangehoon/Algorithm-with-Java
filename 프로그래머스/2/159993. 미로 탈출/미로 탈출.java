import java.util.*;
// 2026-02-25
// 11:35 ~ 12:10
class Solution {
    
    private static final int[] dx = {0 ,0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    public int bfs(char[][] graph, int[] startPos, int[] endPos){
        
        int[][] times = new int[graph.length][graph[0].length];
        for(int i=0; i<times.length; i++){
            Arrays.fill(times[i], -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(startPos);
        times[startPos[0]][startPos[1]] = 0;
        
        while(!queue.isEmpty()){
            
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            
            if(curX==endPos[0] && curY==endPos[1]){
                return times[curX][curY];
            }
            
            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(0<=nx && nx< graph.length && 0<=ny && ny< graph[0].length && graph[nx][ny]!='X' && times[nx][ny]==-1){
                    queue.offer(new int[]{nx, ny});
                    times[nx][ny] = times[curX][curY] +1;
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        
        char[][] graph = new char[maps.length][maps[0].length()];
        int[] startPos = new int[2];
        int[] endPos = new int[2];
        int[] leverPos = new int[2];
        int answer = 0;
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                graph[i][j] = maps[i].charAt(j);
                if(graph[i][j]=='S'){
                    startPos[0] = i;
                    startPos[1] = j;
                }
                else if(graph[i][j]=='L'){
                    leverPos[0] = i;
                    leverPos[1] = j;
                }
                else if(graph[i][j]=='E'){
                    endPos[0] = i;
                    endPos[1] = j;
                }
            }
        }
        
        int time = bfs(graph, startPos, leverPos);
        if(time==-1){
            return -1;
        }
        answer += time;
        
        time = bfs(graph, leverPos, endPos);
        if(time==-1){
            return -1;
        }
        
        answer += time;
        return answer;
    }
}