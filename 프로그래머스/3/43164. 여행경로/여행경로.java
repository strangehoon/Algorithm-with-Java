import java.util.*;
class Solution {
    static boolean[] visited;
    static List<String> result; 
    public static void DFS(int cnt, String now, String path, String[][] tickets){
        if(cnt==tickets.length){
            result.add(path);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(visited[i]==false && tickets[i][0].equals(now)){
                visited[i] = true;
                DFS(cnt+1, tickets[i][1], path +" "+tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }    
    
    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();
        visited = new boolean[tickets.length];
        DFS(0, "ICN", "ICN", tickets);
        Collections.sort(result);
        return result.get(0).split(" ");
    }
}