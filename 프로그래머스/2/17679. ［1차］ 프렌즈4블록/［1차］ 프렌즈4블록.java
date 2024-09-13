import java.util.*;
class Solution {
    
    public class Block{
        boolean isDeleted;
        String name;
        
        public Block(String name){
            this.name = name;
        }
    }
    
    public int solution(int m, int n, String[] board) {
        
        // (1) graph 초기화
        List<List<Block>> graph = new ArrayList<>();
        for(int i=0; i<board[0].length(); i++){
            graph.add(new ArrayList<>());
        }
    
        for(int i=0; i<board[0].length(); i++){
            for(int j=0; j<board.length; j++){
                graph.get(i).add(0, new Block(board[j].substring(i, i+1)));
            }
        }
        
        // (2) 4블록 검사 & 지우기
        int totalCnt = 0;
        while(true){
            for(int i=0; i<graph.size()-1; i++){
                for(int j=0; j<graph.get(i).size()-1; j++){
                    if(graph.get(i).size()<2 || graph.get(i+1).size()<2)
                        break;
                    if(graph.get(i+1).size()-2<j){
                        break;
                    }
                    String first = graph.get(i).get(j).name;
                    String second = graph.get(i).get(j+1).name;
                    String third = graph.get(i+1).get(j).name;
                    String fourth = graph.get(i+1).get(j+1).name;
                    if(first.equals(second) && second.equals(third) && third.equals(fourth)){
                        graph.get(i).get(j).isDeleted = true;
                        graph.get(i).get(j+1).isDeleted = true;
                        graph.get(i+1).get(j).isDeleted = true;
                        graph.get(i+1).get(j+1).isDeleted = true;
                    }

                }
            }
        
            int cnt = 0;
            for(int i=0; i<graph.size(); i++){
                for(int j=graph.get(i).size()-1; j>=0; j--){
                    if(graph.get(i).get(j).isDeleted){
                        graph.get(i).remove(j);
                        cnt++;
                    }
                }
            }    
            
            totalCnt += cnt;
            if(cnt==0){
                break;
            }
        }
        
        return totalCnt;
    }
}