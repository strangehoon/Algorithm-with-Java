import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                map.put(b,map.getOrDefault(b, 0)+1);
            }
            int tem = 1;
            for(String m : map.keySet()){
                tem*=map.get(m)+1;
            }
            bw.write(String.valueOf(tem-1 +"\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
