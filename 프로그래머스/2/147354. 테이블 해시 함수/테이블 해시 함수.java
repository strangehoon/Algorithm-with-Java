import java.util.*;

class Solution {
    // 19:50
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 조건에 따라 정렬
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
        
        // s[i] 값 계산
        int len = row_end-row_begin+1;
        int[] arr = new int[len];
        for(int i=0; i<len; i++){
            int idx = row_begin+i;
            int sum = 0;
            int[] tem = data[idx-1];
            for(int j=0; j<tem.length; j++){
                sum += tem[j]%idx;
            }
            arr[i] = sum;
        }
        
        // Xor 연산
        for(int i=1; i<len; i++){
            String prev = Integer.toString(arr[i-1], 2);
            String cur = Integer.toString(arr[i], 2);
            int prevLen = prev.length();
            int curLen = cur.length();
            //   1010
            // 100101
            StringBuilder sb = new StringBuilder();
            if(prevLen>curLen){
                String tem = prev;
                prev = cur;
                cur = tem;
                prevLen = prev.length();
                curLen = cur.length();
            }
            
            sb.append(cur.substring(0, curLen-prevLen));
            for(int j=0; j<prevLen; j++){
                if(prev.charAt(j)==cur.charAt(j+curLen-prevLen)){
                    sb.append(0);
                }
                else{
                    sb.append(1);
                }
            }
            arr[i] = Integer.parseInt(sb.toString(), 2);
        }
        int answer = arr[len-1];
        return answer;
    }
}

// 0000
// 0100

// 1100