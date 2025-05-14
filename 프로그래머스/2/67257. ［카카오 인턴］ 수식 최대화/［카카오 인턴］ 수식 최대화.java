import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public char[][] priorities = {{'+', '-', '*'}, {'+', '*', '-'}, {'-', '*', '+'},
                          {'-', '+', '*'}, {'*', '+', '-'}, {'*', '-', '+'}};

    public long cal(long first, long second, char op){
        long result = 0;
        switch(op) {
            case '+':
                result = first+second;
                break;
            case '-':   
                result = first-second;
                break;
            case '*':
                result = first*second;
                break;
        }
        return result;
    }
    
    public long solution(String expression) {
        String[] numArr = expression.split("[-+\\*]");
        List<Long> originalNumList = Arrays.stream(numArr).map(Long::parseLong)
            .collect(Collectors.toList());
        
        List<Character> originalOpList = new ArrayList<>();
        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*')
                originalOpList.add(ch);
        }
        
        long answer = 0;
        for(int i=0; i<priorities.length; i++){
            char[] priority = priorities[i];
            
            List<Long> numList = new ArrayList<>(originalNumList);
            List<Character> opList = new ArrayList<>(originalOpList);
            
            for(int j=0; j<priority.length; j++){
                for(int k=0; k<opList.size(); k++){
                    if(opList.get(k)==priority[j]){
                        long first = numList.get(k);
                        long second = numList.get(k+1);
                        numList.set(k, cal(first, second, priority[j]));
                        numList.remove(k+1);
                        opList.remove(k);
                        k--; 
                    }
                }
            }
            answer = Math.max(Math.abs(numList.get(0)), answer);
        }
        return answer;
    }
}
