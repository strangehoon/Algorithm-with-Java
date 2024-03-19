import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int cnt = commands.length;
        int[] result = new int[cnt];
        for(int i=0; i<commands.length; i++){
            int s = commands[i][0];
            int e = commands[i][1];
            int idx = commands[i][2];
            int[] temArr = new int[e-s+1];
            for(int j=0; j<e-s+1; j++){
                temArr[j] = array[s+j-1];
            }
            Arrays.sort(temArr);
            result[i] = temArr[idx-1];
        }
        return result;
    }
}