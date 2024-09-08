// 1:55 ~ 2:03, 2:12
import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.replace("},{", " ");
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        String[] strArr = s.split(" ");
        Arrays.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        
        int len = strArr.length;
        int[] result = new int[len];
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<strArr.length; i++){
            String str = strArr[i];
            String[] temStr = str.split(",");
            for(int j=0; j<temStr.length; j++){
                if(!set.contains(temStr[j])){
                    set.add(temStr[j]);
                    result[i] = Integer.valueOf(temStr[j]);
                }  
            }
        }
        
        return result;
    }
}