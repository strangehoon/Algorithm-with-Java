import java.util.*;
class Solution {
    public int len;
    public boolean[] visited;
    public char[] card;
    public int result = 0;
    public HashSet<Integer> set = new HashSet<>();
    
    public void DFS(String str, int num){
        if(num==len){
            if(!str.equals("") && !set.contains(Integer.valueOf(str))){
                if(isPrime(Integer.valueOf(str))){
                    set.add(Integer.valueOf(str));
                    result++;
                }
            }
            return;
        }
        
        for(int i=0; i<len; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(str+card[i], num+1);
                visited[i] = false;
                DFS(str, num+1);
            }
        }
    }
    
    public boolean isPrime(int num){
        boolean flag = true;
        if(num==0 || num==1)
            return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                flag = false;
                return flag;
            }
        }
        return flag;
    }
    
    public int solution(String numbers) {    
        len = numbers.length();
        card = numbers.toCharArray();
        visited = new boolean[len];
        DFS("", 0);
        
        return result;
    }
}