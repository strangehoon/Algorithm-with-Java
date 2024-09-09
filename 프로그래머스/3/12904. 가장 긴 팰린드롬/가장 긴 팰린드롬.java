import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int result = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=s.length()-1; j>=i; j--){
                if(result>=j-i+1)
                    break;
                
                boolean flag = true;
                for(int k=0; k<=(j-i)/2; k++){
                    if(s.charAt(i+k)!=s.charAt(j-k)){
                        flag = false;
                        break;
                    }
                        
                }
                
                if(flag){
                    result = Math.max(result, j-i+1);
                    break;
                }
                
            }
        }

        return result;
    }
}