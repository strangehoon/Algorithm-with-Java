import java.util.*;

class Solution {

    public List<List<Integer>> graph;
    public int[] info;
    public int answer;
    
    public void dfs(int sheep, int wolf, Set<Integer> remainSet){
        
        answer = Math.max(answer, sheep);
        
        Set<Integer> temSet = new HashSet<>(remainSet);
        
        for(int next : remainSet){
            if(info[next]==0){
                temSet.remove(next);
                temSet.addAll(graph.get(next));
                
                dfs(sheep+1, wolf, temSet);
                
                temSet.add(next);
                temSet.removeAll(graph.get(next));
            }
            else{

                if(sheep>wolf+1){
                    temSet.remove(next);
                    temSet.addAll(graph.get(next));

                    dfs(sheep, wolf+1, temSet);

                    temSet.add(next);
                    temSet.removeAll(graph.get(next));
                }
            }
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        
        this.info = info;
        answer = 0;
        graph = new ArrayList<>();
        for(int i=0; i<info.length; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        
        dfs(1, 0, new HashSet<>(graph.get(0)));
        
        return answer;
    }
}