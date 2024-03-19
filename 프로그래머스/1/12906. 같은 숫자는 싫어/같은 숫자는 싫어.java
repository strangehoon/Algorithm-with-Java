import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int x : arr){
            if(!stack.isEmpty() && stack.peek()==x){
                continue;
            }
            stack.push(x);
        }
        int[] result = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}