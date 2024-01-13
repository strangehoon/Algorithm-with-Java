import java.io.*;
import java.util.*;

public class Main {
    static List<String> result;
    public static void hanoi(int N, int from, int tem, int to){
        if(N==1){
            result.add(from + " " + to);
        }
        else {
            hanoi(N-1, from, to, tem);
            result.add(from + " " + to);
            hanoi(N-1, tem, from, to);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
        hanoi(N, 1, 2, 3);
        bw.write(String.valueOf(result.size()+"\n"));
        for(String str : result){
            bw.write(str+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}