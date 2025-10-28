import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] command = commands[i];
            
            List<Integer> list = new ArrayList<>();
            for(int j=command[0]-1; j<=command[1]-1; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(command[2]-1);
        }

        return answer;
    }
}