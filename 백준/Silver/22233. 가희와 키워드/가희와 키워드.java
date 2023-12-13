import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String w = br.readLine();
            map.put(w, 1);
        }
        for(int i=0; i<M; i++){
            String[] strArr = br.readLine().split(",");
            for(int j=0; j<strArr.length; j++){
                for(String tem : strArr) {
                    if (map.containsKey(tem)) {
                        map.remove(tem);
                    }
                }
            }
            bw.write(String.valueOf(map.size())+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}