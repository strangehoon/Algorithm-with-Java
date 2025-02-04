import java.util.*;

class Solution {
   
    public int transTime(String start, String end){
        int result = 0;
        result += (Integer.parseInt(end.substring(0, 2)) - Integer.parseInt(start.substring(0, 2)))*60;
        result += (Integer.parseInt(end.substring(3, 5)) - Integer.parseInt(start.substring(3, 5)));
        return result;
    }
    
    public String transMusic(int time, String sheet){
        StringBuilder result = new StringBuilder();
        int idx = 0;
        while(time>0){
            char ch = sheet.charAt(idx);
            idx = (idx+1)%sheet.length();
            result.append(ch);
            time--;
        }
        return result.toString();
    }

    public boolean isCorrect(String m, String music){
        if(music.contains(m))
            return true;
        else
            return false;
    }
    
    public class Answer implements Comparable<Answer>{
        int time;
        String title;
        int order;
        
        public Answer(int time, String title, int order){
            this.time = time;
            this.title = title;
            this.order = order;
        }
        @Override
        public int compareTo(Answer a){
            if(this.time==a.time){
                return this.order-a.order;
            }
            else{
                return a.time-this.time;
            }
        }
    }
    public String replaceMusic(String str){
        return str.replaceAll("C#", "c")
            .replaceAll("B#", "b")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a");
    }
    
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<Answer> pq = new PriorityQueue<>();
        String mm = replaceMusic(m);
        for(int i=0, len=musicinfos.length; i<len; i++){
            String[] musicinfoArr = musicinfos[i].split(",");
            int time = transTime(musicinfoArr[0], musicinfoArr[1]);
            String music = transMusic(time, replaceMusic(musicinfoArr[3]));
            boolean flag = isCorrect(mm, music); 
            if(flag){
                pq.offer(new Answer(time, musicinfoArr[2], i));
            }
        }
        if(pq.isEmpty())
            return "(None)";
        else
            return pq.poll().title;
    }
}