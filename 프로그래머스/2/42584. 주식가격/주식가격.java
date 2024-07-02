import java.util.*;
class Solution {
    public class Price {
        int value;
        int idx;
        
        public Price(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            answer[i] = size-i-1; 
        }
        Stack<Price> stack = new Stack<>();
        stack.push(new Price(prices[0], 0));
        for(int i=1; i<size; i++){
            int num = prices[i];
            if(num>=stack.peek().value){
                stack.push(new Price(num, i));
            }
            else{
                boolean flag = true;
                while(!stack.isEmpty()){
                    Price tem = stack.peek();
                    if(num<tem.value){
                        stack.pop();
                        answer[tem.idx] = i-tem.idx;
                    }
                    else{
                        stack.push(new Price(num, i));
                        flag =false;
                        break;
                    }
                }
                if(flag==true){
                    stack.push(new Price(num, i));
                }
            }
        }
        
        return answer;
    }
}