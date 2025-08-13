import java.util.*;

class Solution {

    public class Message {
        String id;
        String command;
        
        public Message(String id, String command){
            this.id = id;
            this.command = command;
        }
    }
    
    public String[] solution(String[] records) {
        Map<String, String> map = new HashMap<>();
        List<Message> messages = new ArrayList<>();
            
        for(String record : records){
            String[] chunk = record.split(" ");
            if(chunk[0].equals("Enter")){
                map.put(chunk[1], chunk[2]);
                messages.add(new Message(chunk[1], "님이 들어왔습니다."));
            }
            else if(chunk[0].equals("Leave")){
       
                messages.add(new Message(chunk[1], "님이 나갔습니다."));
            }
            else{
                map.put(chunk[1], chunk[2]);
            }
        }
        
        String[] results = new String[messages.size()];
        for(int i=0; i<messages.size(); i++){
            results[i] = map.get(messages.get(i).id) + messages.get(i).command;
        }
        
        return results;
    }
}