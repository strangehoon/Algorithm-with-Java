import java.util.*;
// start : 2:25
class Solution {
    List<List<String>> graph;
    Set<String> result = new HashSet<>();
    public void Recur(int dept, Set<String> set, int end){
        if(dept==end){
            List<String> list = new ArrayList<>();
            for(String str : set){
                list.add(str);
            }
            Collections.sort(list);
            String strTem = "";
            for(String str : list){
                strTem += str;
            }
            result.add(strTem);
            return;
        }
        
        // 
        for(String str : graph.get(dept)){
            if(!set.contains(str)){
                set.add(str);
            }
            else{
                continue;
            }
            Recur(dept+1, set, end);
            set.remove(str);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        graph = new ArrayList<>();
        for(int i=0; i<banned_id.length; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<banned_id.length; i++){
            String banStr = banned_id[i];
            for(int j=0; j<user_id.length; j++){
                String userStr = user_id[j];
                boolean flag = true;
                if(banStr.length()!=userStr.length())
                    continue;
                for(int k=0; k<banStr.length(); k++){
                    if(banStr.charAt(k)=='*')
                        continue;
                    else{
                        if(banStr.charAt(k)!=userStr.charAt(k)){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag)
                    graph.get(i).add(userStr);
            }
        }

        Set<String> set = new HashSet<>(); 
        Recur(0, set, banned_id.length);
        
        return result.size();
    }
}