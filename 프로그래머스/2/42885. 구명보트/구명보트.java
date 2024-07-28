import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int j = 0;
        int result = 0;
        for(int i=len-1; i>=j; i--){
            if(people[i]+people[j]<=limit){
                j++;
            }
            result++;
        }
        return result;
    }
}

