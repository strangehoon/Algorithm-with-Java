import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answers = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] command = commands[i];
            int s = command[0];
            int e = command[1];
            int k = command[2];
            List<Integer> list = new ArrayList<>();
            for(int j=s-1; j<=e-1; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answers[i] = list.get(k-1);
        }
        return answers;
    }
}