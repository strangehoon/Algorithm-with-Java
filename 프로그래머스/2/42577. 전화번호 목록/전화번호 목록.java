import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        boolean flag = true;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<len; i++){
            String str = phone_book[i];
            set.add(str);
        }

        for(int i=0; i<len; i++){
            String str = phone_book[i];
            for(int j=1; j<str.length(); j++){
                if(set.contains(str.substring(0, j))){
                    return false;
                }
            }
        }
        return true;
    }
}