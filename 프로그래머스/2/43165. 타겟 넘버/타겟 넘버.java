class Solution {
    
    public int answer;
    public void dfs(int[] numbers, int idx, int sum, int target){
        
        if(idx==numbers.length){
            if(sum==target)
                answer++;
            return;
        }
        
        dfs(numbers, idx+1, sum+numbers[idx]*1, target);
        dfs(numbers, idx+1, sum+numbers[idx]*-1, target);
    }
    
    public int solution(int[] numbers, int target) {
        answer=0;
        dfs(numbers, 0, 0, target);
        return answer;
    }
}