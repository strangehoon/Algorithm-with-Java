import java.util.*;
// 2026/07/18
// 00:00 ~ 

class Solution {
    
    class Genre implements Comparable<Genre>{
        String name;
        int cnt;
        
        public Genre(String name, int cnt){
            this.name = name;
            this.cnt = cnt;
        }
        
        public int compareTo(Genre g){
            return Integer.compare(g.cnt, this.cnt);
        }
    }
    class Song implements Comparable<Song>{
        int idx;
        int cnt;
        
        public Song(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
        
        public int compareTo(Song s){
            if(this.cnt==s.cnt){
                return Integer.compare(this.idx, s.idx);
            }
            else{
                return Integer.compare(s.cnt, this.cnt);
            }
        }
    }
    public List<Integer> solution(String[] genres, int[] plays) {

        Map<String, Integer> genreCntMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            genreCntMap.put(genres[i], genreCntMap.getOrDefault(genres[i], 0)+plays[i]);
            songMap.putIfAbsent(genres[i], new ArrayList<>());
            songMap.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<Genre> genreList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : genreCntMap.entrySet()){
            genreList.add(new Genre(entry.getKey(), entry.getValue()));
        }
        Collections.sort(genreList);
        
        List<Integer> answer = new ArrayList<>();
        for(Genre genre : genreList){
            List<Song> tmpList = songMap.get(genre.name);
            Collections.sort(tmpList);
            
            answer.add(tmpList.get(0).idx);
            if(tmpList.size()>1){
                answer.add(tmpList.get(1).idx);
            }
        }
        return answer;
    }
}