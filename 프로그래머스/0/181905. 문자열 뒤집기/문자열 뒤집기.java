class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        sb.append(my_string.substring(s, e+1)).reverse();
        answer += my_string.substring(0, s);
        answer += sb.toString();
        answer += my_string.substring(e+1, my_string.length());
        
        return answer;
    }
}