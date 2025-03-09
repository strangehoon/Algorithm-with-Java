import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Double, Integer> map = new HashMap<>();

        double[] divide = new double[]{
            1.0, 2.0/3, 1.0/2, 3.0/4
        };

        Arrays.sort(weights);
        for (int weight : weights) {
            for (double d : divide) {
                if (map.containsKey(weight * d)) {
                    answer += map.get(weight * d);
                }
            }
            map.put((double)weight, map.getOrDefault((double)weight, 0) + 1);
        }

        return answer;
    }
}