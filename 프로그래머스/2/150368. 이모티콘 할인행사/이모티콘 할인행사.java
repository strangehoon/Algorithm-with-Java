import java.util.*;
class Solution {
    // 20:30
    
    public class Result implements Comparable<Result>{
        int cnt;
        int money;
        public Result(int cnt, int money){
            this.cnt = cnt;
            this.money = money;
        }
        
        @Override
        public int compareTo(Result r){
            if(this.cnt==r.cnt){
                return r.money-this.money;
            }
            else{
                return r.cnt-this.cnt;
            }
        }
        
    }
    
    public void calculateCombination(int cnt, List<Integer> list, int n, List<List<Integer>> discountPolicys){
        int[] ratios = {10, 20, 30, 40};
        
        if(cnt==n){
            discountPolicys.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0; i<4; i++){
            list.add(ratios[i]);
            calculateCombination(cnt+1, list, n, discountPolicys);
            list.remove(cnt);
        }
        
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        List<List<Integer>> discountPolicys = new LinkedList<>();
        List<Integer> combination = new ArrayList<>();
        calculateCombination(0, combination, emoticons.length, discountPolicys);
        
        PriorityQueue<Result> pq = new PriorityQueue<>();
        for(int i=0, len=discountPolicys.size(); i<len; i++){
            List<Integer> discountPolicy = discountPolicys.get(i);
 
            int totalCnt = 0;
            int totalMoney = 0;
            for(int j=0, usersLen=users.length; j<usersLen; j++){
                int stdRatio = users[j][0];
                int stdMoney = users[j][1];
                int temMoney = 0;
  
                for(int k=0, len1=discountPolicy.size(); k<len1; k++){
                    if(stdRatio<=discountPolicy.get(k)){
                        temMoney += (emoticons[k]*(1-discountPolicy.get(k)/100.0));
                    }
                }
                if(temMoney>=stdMoney){
                    totalCnt +=1;
                }
                else{
                    totalMoney += temMoney;
                }
            }
            pq.offer(new Result(totalCnt, totalMoney));
        }
        
        Result result = pq.poll();
        int[] answer = {result.cnt, result.money};
        return answer;
    }
}
