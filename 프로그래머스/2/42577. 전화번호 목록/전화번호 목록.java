import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return a.length()-b.length();
            }
        });
        
        Set<String> set = new HashSet<>();
        for(String phone : phone_book){
            for(int i=0; i<phone.length(); i++){
                if(set.contains(phone.substring(0, i+1))){
                    return false;
                }
            }
            set.add(phone);
        }

        return true;
    }
}