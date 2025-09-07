import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        
        // 완호 점수 저장
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoSum = wanhoA + wanhoB;
        
        // 근무태도 오름 차순, 동료평가 내림차순
        Arrays.sort(scores, new Comparator<>(){
            @Override
            public int compare(int[] scoreA, int[] scoreB){
                if(scoreA[0]!=scoreB[0]){
                    return scoreA[0]-scoreB[0];
                }
                else{
                    return scoreB[1] - scoreA[1];
                }
            }
        });
        
        // 인센티브 지급 대상 필터링
        boolean[] deleted = new boolean[scores.length];
        for(int i=1; i<scores.length; i++){
            int idx = 1;
            while(i-idx>=0){
                int[] curScore = scores[i];
                int[] prevScore = scores[i-idx];
                if(curScore[0]>prevScore[0] && curScore[1]>prevScore[1]){
                    deleted[i-idx] = true;
                    idx++;
                }
                else{
                    break;
                }
            }
        }
        
        // pq에 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] scoreA, int[] scoreB){
                return scoreB[0]+scoreB[1] - scoreA[0] - scoreA[1];
            }
        });    
        for(int i=0; i<scores.length; i++){
            if(!deleted[i]){
                int[] tem = new int[2];
                tem[0] = scores[i][0];
                tem[1] = scores[i][1];
                pq.offer(tem);
            }
            else if(deleted[i] && scores[i][0]==wanhoA && scores[i][1]==wanhoB){
                return -1;
            }
        }
        
        // 등수 계산
        int rank = 1;
        int answer = -1;
        while(!pq.isEmpty()){
            int[] score = pq.poll();
            if(score[0]+score[1]==wanhoSum){
                answer = rank;
                break;
            }
            rank++;
        }
        return answer;
    }
}
