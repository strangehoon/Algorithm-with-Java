import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Character>> list;
    static boolean[] visited;

    public static void Sol(int num, int dir){
        visited[num] = true;
        if(num+1<=4 && visited[num+1]==false && list.get(num).get(2)!=list.get(num+1).get(6)){
            Sol(num+1, dir*-1);
        }


        if(1<=num-1 && visited[num-1]==false && list.get(num).get(6)!=list.get(num-1).get(2)){
            Sol(num-1, dir*-1);
        }

        Recursion(num, dir);


    }
    public static void Recursion(int num, int dir){
        // 1 : 시계 방향
        if(dir == 1){
            Character tem = list.get(num).remove(7);
            list.get(num).add(0, tem);
        }

        //-1 : 반시계 방향
        else{
            Character tem = list.get(num).remove(0);
            list.get(num).add(7, tem);
        }
    }
    public static int Cal(){
        int score = 0;
        if(list.get(1).get(0)=='1'){
            score +=1;
        }
        if(list.get(2).get(0)=='1'){
            score += 2;
        }
        if(list.get(3).get(0)=='1'){
            score += 4;
        }
        if(list.get(4).get(0)=='1'){
            score += 8;
        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        list = new ArrayList<>();
        for(int i=0; i<=4; i++){
            list.add(new ArrayList<>());
        }

        for(int i=1; i<=4; i++){
            String tem = br.readLine();
            for(int j=0; j<8; j++){
                list.get(i).add(tem.charAt(j));
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            visited = new boolean[5];
            Sol(num, dir);
        }

        bw.write(String.valueOf(Cal()));

        bw.flush();
        bw.close();
        br.close();
    }
}