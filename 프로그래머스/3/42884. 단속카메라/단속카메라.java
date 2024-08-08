import java.util.*;
class Solution {
    public class Route implements Comparable<Route>{
        int start;
        int end;
        
        public Route(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Route route){
            return this.end - route.end;
        }
    }
    
    public int solution(int[][] routes) {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        for(int i=0; i<routes.length; i++){
            pq.offer(new Route(routes[i][0], routes[i][1]));
        }
        
        Route initRoute = pq.poll();
        int tem = initRoute.end;
        int cnt = 1;
        while(!pq.isEmpty()){
            Route route = pq.poll();
            if(route.start<=tem)
                continue;
            else{
                tem = route.end;
                cnt++;
            }
        }
        
        return cnt;
    }
}