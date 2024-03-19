import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> friendsMap = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            friendsMap.put(friends[i], i);
        }
        
        int[][] giftGraph = new int[friends.length][friends.length];
        for(String gift : gifts){
            String[] tem = gift.split(" ");
            String sender = tem[0];
            String receiver = tem[1];
            int senderIdx = friendsMap.get(sender);
            int receiverIdx = friendsMap.get(receiver);
            giftGraph[senderIdx][receiverIdx] += 1;
        }
        
        int[] giftScore = new int[friends.length];
        for(int i=0; i<friends.length; i++){
            int score =  0;
            for(int j=0; j<friends.length; j++){
                score += giftGraph[i][j];
            }
            int b = 0;
            for(int j=0; j<friends.length; j++){
                score -= giftGraph[j][i];
            }
            giftScore[i] = score;
        }
        
        int result[] = new int[friends.length];
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<friends.length; j++){
                if(i==j)
                    continue;
                int a = giftGraph[i][j];
                int b = giftGraph[j][i];
                if(a>b)
                    result[i]++;
                else if(a==b && giftScore[i] > giftScore[j])
                    result[i]++;
            }
        }
        int max = 0;
        for(int x : result){
            max = Math.max(x, max);
        }
    
        
        return max;
    }
}