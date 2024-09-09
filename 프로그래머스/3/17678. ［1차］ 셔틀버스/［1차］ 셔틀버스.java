// 3:20
import java.util.*;
class Solution {
    public String convertMinutesToString(int totalMinutes) {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return String.format("%02d:%02d", hours, minutes);
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        
        // 초기화 및 flag 설정
        List<Integer> timetableToNum = new ArrayList<>();
        int clock = 540;
        int flag = 540+(n-1)*t;
        for(int i=0; i<timetable.length; i++){
            String str = timetable[i];
            String[] strArr = str.split(":");
            int num = Integer.valueOf(strArr[0])*60 + Integer.valueOf(strArr[1]);
            if(flag>=num)
                timetableToNum.add(num);
        }
        Collections.sort(timetableToNum);

        while(true){
            for(int i=0; i<m-1; i++){
                if(timetableToNum.size()>0){
                    int tem = timetableToNum.get(0);
                    if(clock>=tem){
                        timetableToNum.remove(0);
                    }    
                }
            }
            if(n>1){
                if(timetableToNum.size()>0){
                    if(clock>=timetableToNum.get(0)){
                        timetableToNum.remove(0);
                    }    
                }
            }
            else{
                if(timetableToNum.size()!=0){
                    return convertMinutesToString(timetableToNum.get(0)-1);
                }
                else{
                    return convertMinutesToString(clock);
                }
            }
            n--;
            clock += t;
        }
    }
}