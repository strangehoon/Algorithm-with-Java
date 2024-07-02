import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            if(stack.isEmpty() || stack.peek()!=num){
                stack.push(num);
            }
        }
        int size = stack.size();
        int[] result = new int[size];
        for(int i=size-1; i>=0; i--){
            result[i] = stack.pop();
        }

        return result;
    }
}