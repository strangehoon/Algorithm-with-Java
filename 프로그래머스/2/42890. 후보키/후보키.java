import java.util.*;

class Solution {
    
    int row, col;
    String[][] relation;
    List<Set<Integer>> list = new ArrayList<>();
    
    public void dfs(Set<Integer> set, int idx){
        
        if(idx == col){
            if(isUnique(set))
                list.add(new HashSet<>(set));
            return;
        }
        
        set.add(idx);
        dfs(set, idx + 1);
        
        set.remove(idx);
        dfs(set, idx + 1);
    }
    
    public boolean isUnique(Set<Integer> set){
        
        Set<String> a = new HashSet<>();
        for(int i = 0; i < row; i++){
            StringBuilder sb = new StringBuilder();
            for(int j : set){
                sb.append(relation[i][j]).append(" ");
            }
            a.add(sb.toString());
        }
        return a.size() == row;
    }
    
    public int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        this.relation = relation;
        
        dfs(new HashSet<>(), 0);
        
        Collections.sort(list, Comparator.comparingInt(Set::size));
        
        List<Set<Integer>> selected = new ArrayList<>();
        int answer = 0;
        
        for(Set<Integer> set : list){
            boolean flag = true;
            for(Set<Integer> sel : selected){
                if(set.containsAll(sel)){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                selected.add(set);
                answer++;
            }
        }
        
        return answer;
    }
}