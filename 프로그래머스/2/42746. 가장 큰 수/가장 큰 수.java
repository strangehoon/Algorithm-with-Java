import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String [numbers.length];
        for(int i = 0; i<numbers.length; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int result = 0;
                if(s1.length()==s2.length()){
                    result = s2.compareTo(s1);
                }
                else{
                    result = (s2+s1).compareTo(s1+s2);
                }
                return result;
            }
        });
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(String x : strArr){
            if(x.equals("0") && flag ==true){
                continue;
            }
            else{
                flag = false;
                sb.append(x);
            }
        }
        if(sb.toString().isEmpty())
            return "0";
        else
            return sb.toString();
    }
}