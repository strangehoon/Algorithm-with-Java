import java.util.*;
class Solution {
    
    public void dfs(String[] userId, boolean[] isUserIdBanned, List<String> userIdList, String[] bannedId, int banIdx, HashSet<String> set){
        
        if(banIdx==bannedId.length){
            StringBuilder sb = new StringBuilder();
            List<String> temList = new ArrayList<>();
            for(String tem : userIdList)
                temList.add(tem);
            Collections.sort(temList);
            
            for(String tem : temList){
                sb.append(tem);
            }
            
            set.add(sb.toString());
            return;
        }
        
        for(int i=0; i<userId.length; i++){
            if(!isUserIdBanned[i] && checkString(userId[i], bannedId[banIdx])){
                isUserIdBanned[i] = true;
                userIdList.add(userId[i]);
                dfs(userId, isUserIdBanned, userIdList, bannedId, banIdx+1, set);
                isUserIdBanned[i] = false;
                userIdList.remove(userIdList.size()-1);
            }
        }
        
    }
    
    public boolean checkString(String userId, String bannedId){
        if(userId.length() != bannedId.length())
            return false;
        
        int len = userId.length();
        
        for(int i=0; i<len; i++){
            if(bannedId.charAt(i)=='*')
                continue;
            
            else{
                if(bannedId.charAt(i)!=userId.charAt(i))
                    return false;
            }
        }
        return true;
    }
    
    public int solution(String[] userId, String[] bannedId) {
        boolean[] isUserIdBanned = new boolean[userId.length];
        List<String> userIdList = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        dfs(userId, isUserIdBanned, userIdList, bannedId, 0, set);
        
        return set.size();
    }
}