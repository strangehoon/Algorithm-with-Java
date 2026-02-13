import java.util.*;
// 2026-02-13
// 10:35 ~ 10:50
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int transCnt = 0;
        int removedZeroCnt = 0;
        while(!s.equals("1")){
            int oneCnt = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='1'){
                    oneCnt++;
                }
            }
            removedZeroCnt += s.length()-oneCnt;
            s = Integer.toString(oneCnt, 2);
            transCnt ++;
        }
        answer[0] = transCnt;
        answer[1] = removedZeroCnt;
        return answer;
    }
}
