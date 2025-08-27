import java.util.*;

class Solution {
    
    public int len;
    public int wide;
    public char[][] graph;
    public boolean[][] visited;
    public List<Integer> answer;
    public int sum;
    public int[] dx = {0, 0, -1, 1};
    public int[] dy = {1, -1, 0, 0};
    
    public void dfs(int x, int y){
        
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(0<=nx && nx<len && 0<=ny && ny<wide && graph[nx][ny]!='X' && !visited[nx][ny]){
                visited[nx][ny] = true;
                sum += Integer.valueOf(graph[nx][ny]-'0');
                dfs(nx, ny);
            }
        }
    }
    
    public List<Integer> solution(String[] maps) {
        len = maps.length;
        wide = maps[0].length();
        graph = new char[len][wide];
        for(int i=0; i<len; i++){
            for(int j=0; j<wide; j++){
                graph[i][j] = maps[i].charAt(j);
            }
        }
        
        visited = new boolean[len][wide];
        answer = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            for(int j=0; j<wide; j++){
                if(graph[i][j]!='X' && !visited[i][j]){
                    sum = Integer.valueOf(graph[i][j]-'0');
                    visited[i][j] = true;
                    dfs(i, j);
                    answer.add(sum);
                }
            }
        }

        Collections.sort(answer);
        if(answer.isEmpty())
            answer.add(-1);
        return answer;
    }
}