import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int firstCnt = 0;
        int secondCnt = 0;
        int thirdCnt = 0;
        
        for(int i=0; i<answers.length; i++){
            if(first[i%first.length]==answers[i]){
                firstCnt++;
            }
            if(second[i%second.length]==answers[i]){
                secondCnt++;
            }
            if(third[i%third.length]==answers[i]){
                thirdCnt++;
            }
        }
        
        int std = 0;
        std = Math.max(firstCnt, secondCnt);
        std = Math.max(std, thirdCnt);
        List<Integer> result = new LinkedList<>();
        if(std==firstCnt){
            result.add(1);
        }
        if(std==secondCnt){
            result.add(2);
        }
        if(std==thirdCnt){
            result.add(3);
        }
        
        return result;
    }
}