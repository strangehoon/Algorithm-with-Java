import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            map.put(str, 1);
        }
        int cnt = 0;
        List<String> result = new ArrayList<>();
        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(map.containsKey(str)){
                result.add(str);
                cnt++;
            }
        }
        Collections.sort(result);
        bw.write(String.valueOf(cnt)+"\n");
        for(String str : result){
            bw.write(String.valueOf(str)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}