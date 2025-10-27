import java.util.*;
class Solution {
    
    public void dfs(boolean[] visited, String city, String[] cityArr, int idx, String[][] tickets, List<String> list){
        if(idx==tickets.length+1){
            StringBuilder sb = new StringBuilder();
            for(String str : cityArr){
                sb.append(str).append(" ");
            }
            list.add(sb.toString());
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(city.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                cityArr[idx] = tickets[i][1];
                dfs(visited, tickets[i][1], cityArr, idx+1, tickets, list);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        
        boolean[] visited = new boolean[tickets.length];
        String[] cityArr = new String[tickets.length+1];
        cityArr[0] = "ICN";
        List<String> list = new ArrayList<>();
        dfs(visited, "ICN", cityArr, 1, tickets, list);
        
        Collections.sort(list);
        String[] result = list.get(0).split(" ");
        return result;
    }
}