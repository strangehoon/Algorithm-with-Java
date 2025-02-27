class Solution {
 
    public int solution(int storey) {
        
        int answer = 0;
        while(storey>0){
            int num = storey%10;
            
            if(num<5){
                answer += num;
                storey -= num;
            }
            else if(num==5){
                answer += 5;
                int next = (storey/10)%10;
                if(next>=5){
                    storey += 5;
                }
                else{
                    storey -= 5;
                }
            }
            else{
                answer += 10-num;
                storey += 10-num;
            }
            storey /= 10;
        }
        return answer ;
    }
}

