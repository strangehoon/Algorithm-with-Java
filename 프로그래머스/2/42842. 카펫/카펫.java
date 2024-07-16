class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown+yellow;
        int[] result = new int[2];
        for(int i=3; i<=area; i++){
            int j = area/i;
            if((i-2)*(j-2)==yellow){
                result[0] = j;
                result[1] = i;
                break;
            }
        }
        return result;
    }
}