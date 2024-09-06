import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=1; i<=elements.length; i++){
            int tem = 0;
            for(int j=0; j<i; j++){
                tem += elements[j];
            }
            set.add(tem);
            for(int j=i; j<elements.length+i; j++){
                tem += elements[j%elements.length];
                tem -= elements[(j-i)%elements.length];
                set.add(tem);
            }
        }
        
        return set.size();
    }
}