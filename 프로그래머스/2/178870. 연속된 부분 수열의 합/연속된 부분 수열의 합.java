class Solution {
    public int[] solution(int[] sequence, int k) {
        int j=-1;
        int i=-1;
        int[] result = {5, 2000000};
        int sum = 0;
        
        while(true){
            if(sum < k){
                if(i<sequence.length-1)
                    sum += sequence[++i];
                else
                    break;
            }
            else if(sum > k){
                sum -= sequence[++j];
            }
            else{
                if(result[1]-result[0]>i-j){
                    result[1] = i;
                    result[0] = j;
                }
                sum -= sequence[++j];
            }
        }        
        result[0] +=1;
        return result;
    }
}