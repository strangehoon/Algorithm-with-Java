import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        boolean flag = true;
        for(int i=0; i<phone_book.length; i++){
            int len = phone_book[i].length();
            for(int j=1; j<=len; j++){
                String temStr = phone_book[i].substring(0, j);
                if(set.contains(temStr)){
                    flag = false;
                    break;
                }
            }
            if(flag==false){
                break;
            }
            set.add(phone_book[i]);
        }
        Arrays.sort(phone_book, Collections.reverseOrder());
        for(int i=0; i<phone_book.length; i++){
            int len = phone_book[i].length();
            for(int j=1; j<=len; j++){
                String temStr = phone_book[i].substring(0, j);
                if(set2.contains(temStr)){
                    flag = false;
                    break;
                }
            }
            if(flag==false){
                break;
            }
            set2.add(phone_book[i]);
        }
        return flag;
    }
}