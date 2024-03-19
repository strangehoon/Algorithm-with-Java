import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int result = n-lost.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : reserve){
            map.put(x, 1);
        }
        List<Integer> arr = new LinkedList<>();
        for(int tem : lost){
            if(map.containsKey(tem) && map.get(tem)==1){
                map.put(tem, 0);
                result++;
            }
            else
                arr.add(tem);
        }
        Collections.sort(arr);
        for(int tem : arr){
            if(map.containsKey(tem-1) && map.get(tem-1)==1){
                map.put(tem-1, 0);
                result ++;
            }
            else if(map.containsKey(tem+1) && map.get(tem+1)==1){
                map.put(tem+1, 0);
                result ++;
            }
        }
    
        return result;
    }
}