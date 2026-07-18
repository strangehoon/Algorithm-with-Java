import java.util.*;
class Solution {
    List<String> list;
    
    public void dfs(String airport, String[][] tickets, boolean[] visited, int cnt, String str){
        if(cnt==visited.length+1){
            list.add(str);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(airport) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], tickets, visited, cnt+1, str+tickets[i][1]+" ");
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        list = new ArrayList<>();
        dfs("ICN", tickets, visited, 1, "ICN ");
        Collections.sort(list);
        String[] results = list.get(0).split(" ");
        return results;
    }
}