import java.util.*;
class Solution {

    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int move : moves){
            int doll = 0;
            for(int i=0; i<board.length; i++){
                doll = board[i][move-1];
                if(doll!=0){
                    board[i][move-1]=0;
                    // 바구니에 푸시
                    if(stack.isEmpty() || stack.peek()!=doll){
                        stack.push(doll);
                    }
                    // 바구니에서 팝
                    else{
                        stack.pop();
                        cnt+=2;
                    }
                    break;
                }
            }
        }
        
        return cnt;
    }
}
