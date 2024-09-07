import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int)(right-left+1)];
        for(long i = left; i<= right; i++){
            long mok = i/n;
            long na = i%n;
            long num = na+1;
            if(mok>0 && mok-na>0){
                num += mok-na;
            }
            result[(int)(i-left)]= (int)num;
        }

        return result;
    }
}