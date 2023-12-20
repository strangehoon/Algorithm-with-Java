import java.io.*;
import java.util.*;

public class Main {

    public static class Player{
        int level;

        String id;

        public Player(int level, String id){
            this.level = level;
            this.id = id;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Player>> rooms = new ArrayList<>();

        for(int i=0; i<p; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st1.nextToken());
            String id = st1.nextToken();
            Player player = new Player(level, id);
            int size = rooms.size();
            boolean flag = true;
            for(int j=0; j<size; j++){
                int x = rooms.get(j).get(0).level;
                if(rooms.get(j).size()<m) {
                    if (x - 10 <= level && level <= x + 10) {
                        rooms.get(j).add(player);
                        flag = false;
                        break;
                    }
                }
            }
            if(flag ==true){
                List<Player> room = new ArrayList<>();
                room.add(player);
                rooms.add(room);
            }
        }

        for(List<Player> room : rooms){
            Collections.sort(room, new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.id.compareTo(o2.id);
                }
            });
        }
        for(List<Player> room : rooms){
            if(room.size()==m)
                bw.write("Started!\n");
            else
                bw.write("Waiting!\n");

            for(Player player: room){
                bw.write(String.valueOf(player.level+" " + player.id +"\n"));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
