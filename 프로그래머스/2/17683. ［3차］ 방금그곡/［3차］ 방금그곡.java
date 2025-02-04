import java.util.*;

class Solution {
   
    // HH:MM 형식의 시간을 분 단위로 변환
    public int calculateMin(String start, String end){
        int min = 0;
        min += (Integer.parseInt(end.substring(0, 2)) - Integer.parseInt(start.substring(0, 2)))*60;
        min += (Integer.parseInt(end.substring(3, 5)) - Integer.parseInt(start.substring(3, 5)));
        return min;
    }
    
    // 재생 시간 동안 반복된 악보 생성
    public String generatePlayedMelody(int playTime, String sheet) {
        String convertedSheet = convertMelody(sheet);
        int convertedSheetLen = convertedSheet.length();
        StringBuilder playedMelody = new StringBuilder();
        int idx = 0;
        while(playTime>0){
            char ch = convertedSheet.charAt(idx);
            idx = (idx+1)%convertedSheetLen;
            playedMelody.append(ch);
            playTime--;
        }
        return playedMelody.toString();
    }
    
    // 기억한 멜로디가 재생된 음악에 포함되는지 확인
    public boolean isMelodyMatched(String rememberedMelody, String playedMelody) {
        return playedMelody.contains(rememberedMelody);
    }
    
    // 음악 정보를 저장하는 클래스 (우선순위 큐 정렬을 위해 Comparable 구현)
    public class MusicInfo implements Comparable<MusicInfo> {
        int playTime;
        String title;
        int order;

        public MusicInfo(int playTime, String title, int order) {
            this.playTime = playTime;
            this.title = title;
            this.order = order;
        }

        @Override
        public int compareTo(MusicInfo other) {
            if (this.playTime == other.playTime) {
                return this.order - other.order; // 먼저 입력된 곡이 우선
            }
            return other.playTime - this.playTime; // 재생 시간이 긴 곡이 우선
        }
    }
    
     // 멜로디를 변환 (C# -> c, D# -> d 등)
    public String convertMelody(String melody) {
        return melody.replaceAll("C#", "c")
                     .replaceAll("D#", "d")
                     .replaceAll("F#", "f")
                     .replaceAll("G#", "g")
                     .replaceAll("A#", "a")
                     .replaceAll("B#", "b");
    }
    
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<MusicInfo> pq = new PriorityQueue<>();
        String rememberedMelody = convertMelody(m);
        
        for(int i=0, len=musicinfos.length; i<len; i++){
            String[] musicinfoArr = musicinfos[i].split(",");
            int min = calculateMin(musicinfoArr[0], musicinfoArr[1]);
            String playedMelody = generatePlayedMelody(min, musicinfoArr[3]);
            if (isMelodyMatched(rememberedMelody, playedMelody)) {
                pq.offer(new MusicInfo(min, musicinfoArr[2], i));
            }
        }
        if(pq.isEmpty())
            return "(None)";
        else
            return pq.poll().title;
    }
}
