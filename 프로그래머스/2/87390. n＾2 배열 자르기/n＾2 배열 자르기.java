import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answers = new int[(int)(right-left+1)];
        
        for(long i=left; i<=right; i++){
            int row = (int)(i/n);
            int col = (int)(i%n);
            if(row>=col){
                answers[(int)(i-left)] = row+1;
            }
            else if(row<col){
                answers[(int)(i-left)] = col+1;
            }
        }
        return answers;
    }
}