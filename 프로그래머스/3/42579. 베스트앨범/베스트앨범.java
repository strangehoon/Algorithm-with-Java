import java.util.*;
class Solution {
    public class Genre implements Comparable<Genre>{
        String name;
        int sum;
        
        public Genre(String name, int sum) {
            this.name = name;
            this.sum = sum;
        }
        
        @Override
        public int compareTo(Genre genre){
            return genre.sum-this.sum;
        }
    }
    
    public class Song implements Comparable<Song>{
        int idx;
        int num;
        
        public Song(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
        
        @Override
        public int compareTo(Song song){
            if(this.num==song.num){
                return this.idx - song.idx;
            }
            else{
                return song.num - this.num;
            }
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        List<Genre> genreList = new ArrayList<>();
        for(String str : map.keySet()){
            genreList.add(new Genre(str, map.get(str)));
        }
        Collections.sort(genreList);
        
        List<List<Song>> songList = new ArrayList<>();
        for(int i=0; i<genreList.size(); i++){
            songList.add(new ArrayList<>());
        }
        
        for(int i=0; i<plays.length; i++){
            String name = genres[i];
            for(int j=0; j<genreList.size(); j++){
                if(genreList.get(j).name.equals(name)){
                    songList.get(j).add(new Song(i, plays[i]));
                }
            }
        }
        
        for(int i=0; i<songList.size(); i++){
            Collections.sort(songList.get(i));
        }
        
        int idx = 0;
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<genreList.size(); i++){
            for(int j=0; j<songList.get(i).size(); j++){
                if(j==2){
                    break;
                }
                answer.add(songList.get(i).get(j).idx);
            }
        }
        
        return answer;
    }
}