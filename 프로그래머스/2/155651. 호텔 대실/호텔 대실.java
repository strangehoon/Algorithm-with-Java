import java.util.*;
class Solution {
    // 15:30
    public class Book {
        int startTime;
        int endTime;
        
        public Book(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    
    public int transToMin(String str){
        String[] arr = str.split(":");
        int min = 0;
        min += Integer.parseInt(arr[0])*60;
        min += Integer.parseInt(arr[1]);
        return min;
    }
    
    public int solution(String[][] book_time) {
        
        int len = book_time.length;
        PriorityQueue<Book> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.endTime, b.endTime));
        Book[] bookArr = new Book[len];
        
        for(int i=0; i<len; i++){
            int startTime = transToMin(book_time[i][0]);
            int endTime = transToMin(book_time[i][1])+10;
            bookArr[i] = new Book(startTime, endTime);
        }
        
        Arrays.sort(bookArr, (a, b) -> Integer.compare(a.startTime, b.startTime));
        int answer = 0;
        for(int i=0; i<len; i++){
            Book book = bookArr[i];
            // 추가
            if(pq.isEmpty() || pq.peek().endTime > book.startTime){
                pq.offer(book);
            }
            else if(pq.peek().endTime<=book.startTime){
                pq.poll();
                pq.offer(book);
            }
            answer = pq.size();  
        }
        return answer;
    }
}
