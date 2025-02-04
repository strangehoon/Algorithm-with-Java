// 2:15
import java.util.*;
class Solution {
    
    public class Score{
        int idx;
        int attitude;
        int mate;
        
        public Score(int idx, int attitude, int mate){
            this.idx = idx;
            this.attitude = attitude;
            this.mate = mate;
        }
    }
    
    public int solution(int[][] scores) {
        
        List<Score> list = new ArrayList<>();
        for(int i=0, len=scores.length; i<len; i++){
            list.add(new Score(i, scores[i][0], scores[i][1]));
        }
        list.sort(new Comparator<Score>(){
            @Override
            public int compare(Score s1, Score s2){
                if(s1.attitude==s2.attitude){
                    return s2.mate-s1.mate;
                }
                else{
                    return s1.attitude-s2.attitude;
                }
            }
        });
        
        Stack<Score> stack = new Stack<>();
        for(Score score : list){
            if(stack.isEmpty())
                stack.push(score);
            else{
                while(!stack.isEmpty() && stack.peek().attitude<score.attitude && stack.peek().mate<score.mate){
                    stack.pop();
                }
                stack.push(score);
            }
        }
        
        List<Score> rankList = new ArrayList<>();
        for(Score score : stack){
            rankList.add(score);
        }
        
        rankList.sort(new Comparator<Score>(){
            @Override
            public int compare(Score s1, Score s2){
                
                if(s1.attitude+s1.mate == s2.attitude+s2.mate){
                    return s1.idx-s2.idx;
                }
                else{
                    return (s2.attitude+s2.mate) - (s1.attitude+s1.mate);
                }
            }
        });
        
        int answer = -1;
        for(int i=0,len=rankList.size(); i<len; i++){
            Score score = rankList.get(i);
            if(score.idx==0){
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}