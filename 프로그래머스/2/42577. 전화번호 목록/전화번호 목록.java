import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for(int i=0; i<len; i++){
            String str = phone_book[i];
            boolean flag = true;
            for(int j=0; j<str.length(); j++){
                String tem = str.substring(0, j+1);
                if(set1.contains(tem)){
                    flag = false;
                    break;
                }
            }
            if(flag)
                set1.add(str);
        }

        for(int i=len-1; i>=0; i--){
            String str = phone_book[i];
            boolean flag = true;
            for(int j=0; j<str.length(); j++){
                String tem = str.substring(0, j+1);
                if(set2.contains(tem)){
                    flag = false;
                    break;
                }
            }
            if(flag)
                set2.add(str);
        }
        if(set1.size()==len && set2.size()==len)
            return true;
        else
            return false;
        
    }
}