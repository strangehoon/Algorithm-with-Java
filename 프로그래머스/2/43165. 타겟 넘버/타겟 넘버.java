import java.util.*;
class Solution {
    public int[] numbers;
    public int target;
    public int answer = 0;
    public void DFS(int i, int sum){
        if(i==numbers.length){
            if(sum==target)
                answer++;    
            return;
        }
        // 덧셈
        DFS(i+1, sum + numbers[i]);
        // 뺄셈
        DFS(i+1, sum - numbers[i]);
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        DFS(0, 0);
        return answer;
    }
}