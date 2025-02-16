class Solution {
    public int solution(String myString, String pat) {
        
        int cnt = 0;
        for(int i=0, len=myString.length(); i<len; i++){
            String str = myString.substring(0, i+1);
            if(str.endsWith(pat))
                cnt++;
        }
        
        return cnt;
    }
}