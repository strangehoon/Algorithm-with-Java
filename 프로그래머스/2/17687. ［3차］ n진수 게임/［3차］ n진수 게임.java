import java.util.*;
class Solution {

    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<100000; i++){
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        String str = sb.toString();
        
        StringBuilder result = new StringBuilder();
        int cnt = t;
        while(cnt>0){
            result.append(String.valueOf(str.charAt(p-1)));
            p= p+m;
            cnt--;
        }
        return result.toString();
    }
}