import java.util.*;
class Solution {

    public int solution(String numbers) {    
        int size = (int)Math.pow(10, numbers.length());
        // 소수  O : false, 소수 X : true
        boolean[] arr = new boolean[size];
        for(int i=2; i<size; i++){
            for(int j=i+i; j<size; j+=i){
                arr[j] = true;
            }
        }
        int result = 0;
        for(int i=2; i<size; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(char ch : numbers.toCharArray()){
                int tem = ch-'0';
                map.put(tem, map.getOrDefault(tem, 0)+1);
            }
            
            String str = String.valueOf(i);
            int len = str.length();
            boolean flag = true;
            for(int j=0; j<len; j++){
                int num = str.charAt(j)-'0';
                if(!map.containsKey(num) || map.get(num)==0){
                    flag = false;
                    break;    
                }
                else if(map.get(num)>0){
                    map.put(num, map.get(num)-1);
                }
            }
            if(flag && !arr[i]){
                result++;
            }
        }
        return result;
    }
}