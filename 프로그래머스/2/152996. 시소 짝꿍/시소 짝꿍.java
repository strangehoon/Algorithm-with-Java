// 16:15
import java.util.*;
class Solution {
    public long solution(int[] weights) {
        
        HashMap<Double, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        double[] torques = {(double)1/1, (double)2/3, (double)2/4, (double)3/4};
        long answer = 0;
        
        for(int i=0, weightsLen=weights.length; i<weightsLen; i++){
            for(int j=0, torqueLen=torques.length; j<torqueLen; j++){
                double temWeight = weights[i]*torques[j];
                answer += map.getOrDefault(temWeight, 0);
            }
            map.put((double)weights[i], map.getOrDefault((double)weights[i], 0)+1);
        }
        return answer;
    }
}


