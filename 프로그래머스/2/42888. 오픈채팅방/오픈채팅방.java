import java.util.*;
// 16:45

class Solution {
    // map 
    public class Message {
        String id;
        String command;
        
        public Message(String id, String command){
            this.id = id;
            this.command = command;
        }
    }
    
    public String solution(String[] records) {
        Map<String, String> map = new HashMap<>();
        List<Message> messages = new ArrayList<>();
            
        for(String record : records){
            String[] chunk = record.split(" ");
            if(chunk[0].equals("Enter")){
                map.put(chunk[1], chunk[2]);
                messages.add(new Message(chunk[1], "님이 들어왔습니다."));
            }
            else if(chunk[0].equals("Leave")){
                map.remove(chunk[1]);                
                messages.add(new Message(chunk[1], "님이 나갔습니다."));
            }
            else{
                map.put(chunk[1], chunk[2]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Message message : messages){
            sb.append(map.get(message.id) + message.command);
        }
        return sb.toString();
    }
}