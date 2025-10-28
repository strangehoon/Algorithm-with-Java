import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreToSumMap = new HashMap<>();
        Map<String, List<int[]>> genreToPlayMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genreToSumMap.put(genres[i], genreToSumMap.getOrDefault(genres[i], 0)+plays[i]);
            if(!genreToPlayMap.containsKey(genres[i]))
                genreToPlayMap.put(genres[i], new ArrayList<>());
        }
        
        for(int i=0; i<genres.length; i++){
            genreToPlayMap.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<Integer> sumList = new ArrayList<>();
        for(int sum : genreToSumMap.values()){
            sumList.add(sum);
        }
        Collections.sort(sumList, Collections.reverseOrder());

        List<Integer> answer = new ArrayList<>();
        
        for(int sum : sumList){
            for(Map.Entry<String, Integer> entry : genreToSumMap.entrySet()){
                List<int[]> playMapList = genreToPlayMap.get(entry.getKey());
                if(entry.getValue()==sum){
                    Collections.sort(playMapList, new Comparator<int[]>(){
                        @Override
                        public int compare(int[] arr1, int[] arr2){
                            if(arr1[1]!=arr2[1]){
                                return arr2[1]-arr1[1];
                            }
                            else{
                                return arr1[0]-arr2[0];
                            }
                        }
                    });
                    answer.add(playMapList.get(0)[0]);
                    if(playMapList.size()>1)
                        answer.add(playMapList.get(1)[0]);
                }
            }
        }

        return answer;
    }
}