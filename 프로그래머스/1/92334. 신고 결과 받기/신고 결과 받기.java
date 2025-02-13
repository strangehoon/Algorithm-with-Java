import java.util.*;
class Solution {

    public int[] solution(String[] idList, String[] reports, int k) {
        
        Set<Integer>[] sets = new HashSet[idList.length]; 
        for (int i = 0, idListLen=idList.length; i<idListLen; i++) {
            sets[i] = new HashSet<>();
        }
        
        // 이름을 idx로 변환해주는 map
        Map<String, Integer> idxMap = new HashMap<>();
        for(int i=0, idListLen=idList.length; i<idListLen; i++){
            idxMap.put(idList[i], i);
        }
        
        // 신고받은 횟수를 저장하는 배열
        int[] reportCnt = new int[idList.length];
        for(int i=0, reportsLen=reports.length; i<reportsLen; i++){
            String[] report = reports[i].split(" ");
            int reporterIdx = idxMap.get(report[0]);
            int reportedIdx = idxMap.get(report[1]);
            if(!sets[reporterIdx].contains(reportedIdx)){
                sets[reporterIdx].add(reportedIdx);
                reportCnt[reportedIdx] ++;    
            }
        }
        
        // 처리 결과 메일을 받은 횟수를 담은 배열
        int[] answers = new int[idList.length];
        for(int i=0, idListLen1=idList.length; i<idListLen1; i++){
            if(reportCnt[i]>=k){
                for(int j=0, idListLen2=idList.length; j<idListLen2; j++){
                    if(sets[j].contains(i)){
                        answers[j]++;
                    }
                }
                
            }
        }
        
        return answers;
    }
}