import java.util.*;
class Solution {
    public boolean[] arr;
    
    public int solution(int n, int[] stations, int w) {
        // init
        int idx = 1;
        int[] arr = new int[stations.length+1];
        for(int i=0; i<stations.length; i++){
            arr[i] = stations[i];
        }
        arr[stations.length] = n+w+1;
        
        // logic
        int jdx = 0;
        int total = 0;
        while(jdx<arr.length){
            int tem = arr[jdx];
            int begin = tem-w;
            int end = tem+w;
            if(idx<begin){
                total += (begin-idx)/(2*w+1);
                if((begin-idx)%(2*w+1)!=0)
                    total+=1;
            }
            idx = end+1;
            jdx++;
        }
        return total;
    }
}