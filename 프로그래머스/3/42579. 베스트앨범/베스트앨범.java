import java.util.*;
class Solution {
    public class Play{
        int cnt;
        int idx;
        public Play(int cnt, int idx){
            this.cnt = cnt;
            this.idx = idx;
        }
    }
    
    public class Genre{
        int sumCnt;
        int idx;
        public Genre(int sumCnt, int idx){
            this.sumCnt = sumCnt;
            this.idx = idx;
        }
    }
    public List<Integer> solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Genre> genreList = new ArrayList<>();
        List<List<Play>> playList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<genres.length; i++){
            playList.add(new ArrayList<>());
        }
        int idx = 0;
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            if(map.get(genre)==null){
                map.put(genre, idx);
                idx++;
            }
            playList.get(map.get(genre)).add(new Play(plays[i], i));
        }
        for(int i=0; i<genres.length; i++){
            int sum = 0;
            for(Play x : playList.get(i)){
                sum += x.cnt;
            }
            genreList.add(new Genre(sum, i));
        }
        Collections.sort(genreList, new Comparator<>(){
            @Override
            public int compare(Genre g1, Genre g2){
                return g2.sumCnt - g1.sumCnt;
            }
        });
        
        for(Genre g : genreList){
            List<Play> tem = playList.get(g.idx);
            Collections.sort(tem, new Comparator<>(){
                @Override
                public int compare(Play p1, Play p2){
                    if(p1.cnt==p2.cnt){
                        return p1.idx - p2.idx;
                    }
                    else{
                        return p2.cnt - p1.cnt;
                    }
                }
            });
            if(tem.size()>0){
                result.add(tem.get(0).idx);
                if(tem.size()>1){
                   result.add(tem.get(1).idx);
                }
            }
        }
        return result;
    }
}