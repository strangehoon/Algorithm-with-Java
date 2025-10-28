import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] numStrArr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            numStrArr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numStrArr, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                return (str2+str1).compareTo(str1+str2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String str : numStrArr){
            sb.append(str);
        }
        
        if(sb.toString().charAt(0)=='0')
            return "0";
        else
            return sb.toString();
    }
}