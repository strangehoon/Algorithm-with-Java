class Solution {
    public String[] solution(String[] strArr) {
        String[] answers = new String[strArr.length];
        
        for(int i=0; i<strArr.length; i++){
            String str = strArr[i];
            if(i%2==0)
                answers[i] = str.toLowerCase();
            else
                answers[i] = str.toUpperCase();
        }
        
        return answers;
    }
}