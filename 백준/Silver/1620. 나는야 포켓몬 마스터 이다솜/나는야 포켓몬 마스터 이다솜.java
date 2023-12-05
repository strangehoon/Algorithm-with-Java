import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] str = new String[M];
        for(int i=1; i<N+1; i++){
            String tmp = br.readLine();
            map1.put(tmp,i);
            map2.put(i, tmp);
        }
        for(int i=0; i<M; i++){
            str[i] = br.readLine();
        }

        for(int i=0; i<str.length; i++){
            if(Character.isAlphabetic(str[i].charAt(0))){
                bw.write(map1.get(str[i]) +"\n");
            }
            else{
                bw.write(map2.get(Integer.parseInt(str[i])) + "\n");
            }
        }
        bw.close();
        br.close();
    }
}