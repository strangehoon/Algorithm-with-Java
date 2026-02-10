import java.util.*;
// 2026-02-10
// 11:10 ~ 11:18
class Solution {
    public String solution(String s) {
        int[] strArr = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray(); 
        
        String answer = "";
        answer += strArr[0] +" " +strArr[strArr.length-1];
        
        return answer;
    }
}