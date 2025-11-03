import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reversePq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
        for(String operation : operations){
            String[] strArr = operation.split(" ");
            if(strArr[0].equals("I")){
                int num = Integer.parseInt(strArr[1]);
                map.put(num, map.getOrDefault(num, 0)+1);
                pq.offer(num);
                reversePq.offer(num);
            }
            else if(strArr[1].equals("1")){
                while(!reversePq.isEmpty()){
                    int num = reversePq.poll();
                    if(map.get(num)!=0){
                        map.put(num, map.get(num)-1);
                        break;
                    }
                }
            }
            else{
                while(!pq.isEmpty()){
                    int num = pq.poll();
                    if(map.get(num)!=0){
                        map.put(num, map.get(num)-1);
                        break;
                    }
                }
            }
        }
        int[] answer = new int[2];
        while(!reversePq.isEmpty()){
            int num = reversePq.poll();
            if(map.get(num)!=0){
                reversePq.offer(num);
                answer[0] = num;
                break;
            }
        }
        
        while(!pq.isEmpty()){
            int num = pq.poll();
            if(map.get(num)!=0){
                pq.offer(num);
                answer[1]= num;
                break;
            }
        }
        
        return answer;
    }
}