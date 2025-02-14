import java.util.*;
class Solution {
    // 17:30 ~ 19:00
    
    public String convertNumToString(int num){
        if(num<10){
            return "0"+String.valueOf(num);
        }
        else{
            return String.valueOf(num);
        }
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        
        HashMap<Character, Integer> termsMap = new HashMap<>();
        List<Integer> answers = new ArrayList<>();
        
        // 약관 정보를 map에 저장
        for(String term : terms){
            String[] info = term.split(" ");
            termsMap.put(info[0].charAt(0), Integer.parseInt(info[1]));
        }
        // today보다 작거나 같으면 파기
        for(int i=1, len=privacies.length; i<=len; i++){
            String[] privacyInfo = privacies[i-1].split(" ");
            String[] dateInfo = privacyInfo[0].split("[.]");
            int year = Integer.parseInt(dateInfo[0]);
            int month = Integer.parseInt(dateInfo[1]);
            String date = dateInfo[2];
            
            Character termType = privacyInfo[1].charAt(0);
            int termMonth = termsMap.get(termType);
            
            StringBuilder newDate = new StringBuilder();
            int newYear = year;
            int newMonth = month;
   
            if((newMonth+termMonth)%12==0){
                newYear += (newMonth+termMonth)/12 -1;
                newMonth = 12;
            } 
            else{
                newYear += (newMonth+termMonth)/12;
                newMonth = (newMonth+termMonth)%12;
            }
            
                
            newDate.append(newYear).append(".").append(convertNumToString(newMonth)).append(".").append(date);
            
            String deadLine = newDate.toString();
            if(deadLine.compareTo(today)<=0){
                answers.add(i);
            }
        }
        
        return answers;
    }
}