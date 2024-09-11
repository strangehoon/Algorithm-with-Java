import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<26; i++){
            char ch = (char)('A'+i);
            map.put(String.valueOf(ch), i+1);
        }
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int num = 27;
        while(idx < msg.length()){
            String str = String.valueOf(msg.charAt(idx));
            sb.append(str);
            if(map.containsKey(sb.toString())){
                idx++;
                continue;
            }
            else{
                map.put(sb.toString(), num++);
                sb.deleteCharAt(sb.length()-1);
                list.add(map.get(sb.toString()));
                sb.setLength(0);
                sb.append(str);
                idx++;
            }
        }
        list.add(map.get(sb.toString()));
        return list;
    }
}