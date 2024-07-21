import java.util.*;
class Solution {
    public char[] chArr= {'A', 'E', 'I', 'O', 'U'};
    public int order = 1;
    public HashMap<String, Integer> map = new HashMap<>();
    public void DFS(int cnt, String str){
        if(cnt>=chArr.length)
            return;
        for(int i=0; i<chArr.length; i++){
            map.put(str+chArr[i], order++);
            DFS(cnt+1, str+chArr[i]);
        }
    }
    
    public int solution(String word) {
        DFS(0, "");
        return map.get(word);
    }
}