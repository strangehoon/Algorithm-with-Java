class Solution {
    public int solution(int[] citations) {
        
        int h = 1000;
        int answer = 0;
        while(h>=0){
            int cnt = 0;
            for(int citation : citations){
                if(citation>=h){
                    cnt++;
                }
            }
            if(cnt>=h){
                answer = h;
                break;
            }
            h--;
        }
        return answer;
    }
}




