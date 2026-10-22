import java.util.*;

class Solution {
    
    public List<String> list = new ArrayList<>();
    
    public void dfs(String cur, int cnt, int goal, Map<String, List<String>> map, Map<String, boolean[]> visited, String str){

        if(cnt>=goal){
            list.add(str);
            return;
        }
        
        if(!map.containsKey(cur)){
            return;
        }
        
        for(int i=0; i<map.get(cur).size(); i++){
            String next = map.get(cur).get(i);
            if(!visited.get(cur)[i]){
                visited.get(cur)[i] =true;
                dfs(next, cnt+1, goal, map, visited, str+" "+next);
                visited.get(cur)[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        
        Map<String, List<String>> map = new HashMap<>();
        Map<String, boolean[]> visited = new HashMap<>();
        
        for(String[] ticket : tickets){
            if(map.containsKey(ticket[0])){
                map.get(ticket[0]).add(ticket[1]);
            }
            else{
                map.put(ticket[0], new ArrayList<>());
                map.get(ticket[0]).add(ticket[1]);
            }
        }
        
        for(String key : map.keySet()){
            visited.put(key, new boolean[map.get(key).size()]);
        }
        
        dfs("ICN", 1, tickets.length+1, map, visited, "ICN");
        
        Collections.sort(list);
        
        String[] answer = list.get(0).split(" ");
        return answer;
    }
}