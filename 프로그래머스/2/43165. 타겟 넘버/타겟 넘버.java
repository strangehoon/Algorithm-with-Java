class Solution {
    public int[] numbers;
    public int target;
    public int cnt = 0;
    public void DFS(int idx, int sum){
        if(idx==numbers.length){
            if(sum==target){
                cnt++;
            }
            return;
        }
        else{
            DFS(idx+1, sum+numbers[idx]);
            DFS(idx+1, sum-numbers[idx]);    
        }
    }
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        DFS(0, 0);    
        return cnt;
    }
}