import java.util.*;
class Solution {
    
    public boolean[] visited;
    public String[][] tickets;
    public List<String> results = new ArrayList<>();
    
    public void DFS(String start, String str, int num){
        if(num==tickets.length){
            results.add(str);
            return;
        }
    
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                DFS(tickets[i][1], str+tickets[i][1], num+1);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        this.tickets = tickets;
        DFS("ICN", "ICN", 0);
        Collections.sort(results);
        String str = results.get(0);
        String[] answer = new String[tickets.length+1];
        for(int i=0; i<tickets.length+1; i++){
            answer[i] = str.substring(i*tickets[0][0].length(), (i+1)*tickets[0][0].length());
        }
        return answer;
    }
}