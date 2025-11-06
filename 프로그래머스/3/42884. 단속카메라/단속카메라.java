import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[1]-arr2[1];
            }
        });
        int std = routes[0][1];
        int answer = 1;
        for(int i=1; i<routes.length; i++){
            int[] route = routes[i];
            
            if(route[0]<=std){
                continue;
            }
            else{
                std = route[1];
                answer ++;
            }   
        } 
        return answer;
    }
}