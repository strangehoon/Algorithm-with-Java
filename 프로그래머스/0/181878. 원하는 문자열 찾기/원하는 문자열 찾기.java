class Solution {
    public int solution(String myString, String pat) {
        
        String newMyString = myString.toUpperCase();
        String newPat = pat.toUpperCase();
        
        return newMyString.contains(newPat)==true ? 1 : 0;
    }
}