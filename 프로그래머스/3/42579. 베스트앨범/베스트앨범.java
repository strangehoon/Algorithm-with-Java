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
    
    public class Gen{
        int sumPlay;
        int index;
        public Gen(int sumPlay, int index){
            this.sumPlay = sumPlay;
            this.index = index;
        }
    }
    public List<Integer> solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Gen> gens = new ArrayList<>();
        List<List<Play>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<genres.length; i++){
            list.add(new ArrayList<>());
        }
        int idx = 0;
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            if(map.get(genre)==null){
                map.put(genre, idx);
                idx++;
                list.add(new ArrayList<>());
            }
            list.get(map.get(genre)).add(new Play(plays[i], i));
        }
        for(int i=0; i<genres.length; i++){
            int sum = 0;
            for(Play x : list.get(i)){
                sum += x.cnt;
            }
            gens.add(new Gen(sum, i));
        }
        Collections.sort(gens, new Comparator<>(){
            @Override
            public int compare(Gen g1, Gen g2){
                return g2.sumPlay - g1.sumPlay;
            }
        });
        
        for(Gen g : gens){
            List<Play> tem = list.get(g.index);
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