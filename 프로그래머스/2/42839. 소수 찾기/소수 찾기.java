import java.util.*;

class Solution {
    public int solution(String numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        
        boolean[] arr = new boolean[10000000];
        arr[0] = true;
        arr[1] = true;
        for(int i=2; i<10000000; i++){
            for(int j=i+i; j<10000000; j+=i){
                arr[j]=true;
            }
        }
        
        int answer = 0;
        for(int i=2; i<10000000; i++){
            boolean flag = true;
            for(int j=0; j<numbers.length(); j++){
                int tmp = numbers.charAt(j)-'0';
                map.put(tmp, map.getOrDefault(tmp, 0)+1);
            }
            
            if(!arr[i]){
                String str = String.valueOf(i);
                for(int j=0; j<str.length(); j++){
                    int num = str.charAt(j)-'0';
                    if(!map.containsKey(num) || map.get(num)<=0){
                        flag = false;
                        break;
                    }
                    else{
                        map.put(num, map.get(num)-1);
                    }
                }
                if(flag==true){
                    answer++;
                }
            }
            map.clear();
        }
        return answer;
    }
}