class Solution {
    // 15:40
    public int solution(int[] players, int m, int k) {
        int len = players.length;
        int[] curServer = new int[len];
        int answer = 0;
        for(int i=0; i<len; i++){
            if(players[i]/m > curServer[i]){
                int tem = players[i]/m - curServer[i];
                answer += tem;
                for(int j=0; j<k; j++){
                    if(i+j<len){
                        curServer[i+j] += tem;
                    }
                }
            }
        }
        return answer;
    }
}