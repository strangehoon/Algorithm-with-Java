import java.util.*;
// 2026-02-25
// 14:25 ~ 14:35

class Solution {
    public int solution(int n) {
        
        String stdStr = Integer.toString(n, 2);
        int stdCnt = 0;
        for(int i=0; i<stdStr.length(); i++){
            if(stdStr.charAt(i)=='1'){
                stdCnt++;
            }
        }
        
        int answer = n+1;
        while(true){
            int cnt = 0;
            String str = Integer.toString(answer, 2);
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)=='1'){
                    cnt++;
                }
            }
            
            if(cnt==stdCnt){
                return answer;
            }
            else{
                answer++;
            }
        }
    }
}