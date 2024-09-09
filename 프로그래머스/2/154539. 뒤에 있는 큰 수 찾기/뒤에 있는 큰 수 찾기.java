// 3:30
import java.util.*;
class Solution {
    
    public int[] solution(int[] numbers) {
        
        int[] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<numbers.length; i++){
            result[i] = -1;
        }
        
        for(int i=numbers.length-1; i>=0; i--){
            if(stack.isEmpty()){
                stack.push(numbers[i]);
            }
            else if(stack.peek()<=numbers[i]){
                while(!stack.isEmpty()){
                    int tem = stack.peek();
                    if(tem>numbers[i]){
                        result[i] = tem;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
                stack.push(numbers[i]);
            }
            else {
                result[i] = stack.peek();
                stack.push(numbers[i]);
            }
        }
    
        return result;
    }
}