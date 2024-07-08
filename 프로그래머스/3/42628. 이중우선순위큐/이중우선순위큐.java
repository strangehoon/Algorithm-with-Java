import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer[] arr = new Integer[5];
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });
        PriorityQueue<Integer> maxHp = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        PriorityQueue<Integer> minHp = new PriorityQueue<>();
        for(String str : operations){
            if(str.charAt(0)=='I'){
                Integer tem = Integer.valueOf(str.substring(2, str.length()));
                maxHp.offer(tem);
                minHp.offer(tem);
                map.put(tem, map.getOrDefault(tem, 0)+1);
            }
            else{
                if(str.charAt(2)=='-'){
                    Integer a = minHp.poll();
                    while(a!=null){
                        if(map.get(a)==0){
                            a = minHp.poll();
                        }    
                        else{
                            map.put(a, map.get(a)-1);
                            break;
                        }
                    }
                }
                else{
                    Integer b = maxHp.poll();
                    while(b!=null){
                        if(map.get(b)==0){
                            b = maxHp.poll();
                        }    
                        else{
                            map.put(b, map.get(b)-1);
                            break;
                        }
                    }
                }
            }
        }
        
        int[] result = new int[2];
        Integer a = minHp.poll();
        while(a!=null){
            if(map.get(a)==0){
                a = minHp.poll();
            }    
            else{
                break;
            }
        }
        if(a==null)
            result[1] = 0;
        else
            result[1] = a;
        
        Integer b = maxHp.poll();
        while(b!=null){
            if(map.get(b)==0){
                b = maxHp.poll();
            }    
            else{
                break;
            }
        }
        if(b==null)
            result[0] = 0;
        else
            result[0] = b;
        return result;
    }
}