import java.util.*;

class Solution {
    
    public boolean checkPrime(String chunkStr){
        if(chunkStr.equals("") || chunkStr.equals("1"))
            return false;
        long chunkNum = Long.valueOf(chunkStr);
        
        for(int i=2; i<=(int)(Math.sqrt(chunkNum)); i++){
           if(chunkNum%i==0){
               return false;
           } 
        }
        return true;
    }
    
    public int solution(int n, int k) {
        String radixNum = Integer.toString(n, k);
        System.out.println(radixNum);
        int len = radixNum.length();
        
        int idx = 0;
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int jdx=0; jdx<len; jdx++){
            if(radixNum.charAt(jdx)!='0'){
                sb.append(radixNum.charAt(jdx));
            }
            else{
                if(checkPrime(sb.toString()))
                    answer++;
                sb.delete(0, sb.length());
            }
        }
        
        if(checkPrime(sb.toString())){
            answer++;
        }
        
        return answer;
    }
}