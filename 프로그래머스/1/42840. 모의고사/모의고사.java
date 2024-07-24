import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] first_person = {1, 2, 3, 4, 5};
        int[] second_person = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third_person = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int first_cnt = 0;
        int second_cnt = 0;
        int third_cnt = 0;
        
        List<Integer> list = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for(int i=0; i<answers.length; i++){
            if(first_person[i%first_person.length]==answers[i]){
                first_cnt++;
            }
            if(second_person[i%second_person.length]==answers[i]){
                second_cnt++;
            }
            if(third_person[i%third_person.length]==answers[i]){
                third_cnt++;
            }
        }
        list.add(first_cnt);
        list.add(second_cnt);
        list.add(third_cnt);
        
        int max_value = Math.max(first_cnt, Math.max(second_cnt, third_cnt));
        for(int i=0; i<3; i++){
            if(list.get(i)==max_value){
                resultList.add(i+1);
            }
        }
        
        return resultList;
    }
}