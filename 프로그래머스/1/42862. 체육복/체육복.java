import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        for(int num : lost)
            lostSet.add(num);
        
        for(int num : reserve){
            if(lostSet.contains(num)){
                lostSet.remove(num);
            }
            else{
                reserveSet.add(num);
            }
        }
        
        for(int num : reserveSet){
            if(lostSet.contains(num-1)){
                lostSet.remove(num-1);
                reserveSet.remove(num-1);
            }
            else if(lostSet.contains(num+1)){
                lostSet.remove(num+1);
                reserveSet.remove(num+1);
            }
        }
        
        return n-lostSet.size();
    }
}