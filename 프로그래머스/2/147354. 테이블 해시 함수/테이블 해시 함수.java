import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
          
        Arrays.sort(data, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[col-1]!=b[col-1]){
                    return a[col-1]-b[col-1];
                }
                else{
                    return b[0]-a[0];
                }
            }
        });
        
        int answer = 0;
        
        for(int i=row_begin-1; i<row_end; i++){
            int[] tem = data[i];
            int sum = 0;
            for(int j=0; j<tem.length; j++){
                sum += tem[j]%(i+1);
            }
            answer = answer ^ sum;    
        }
        return answer;
    }
}
