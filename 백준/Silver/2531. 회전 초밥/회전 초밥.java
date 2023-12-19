import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int result = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            arrayList.add(x);
        }

        for(int i=0; i<k; i++){
            map.put(arrayList.get(i), map.getOrDefault(arrayList.get(i), 0)+1);
        }
        if(map.containsKey(c))
            result = map.size();
        else
            result = map.size()+1;
        int cnt = 1;
        int i = k;
        int j = 0;
        while (cnt++<N){
            map.put(arrayList.get(i%N), map.getOrDefault(arrayList.get(i%N), 0)+1);
            map.put(arrayList.get(j%N), map.get(arrayList.get(j%N))-1);
            if(map.get(arrayList.get(j%N))<1){
                map.remove(arrayList.get(j%N));
            }
            if(map.containsKey(c))
                result = Math.max(result, map.size());
            else
                result = Math.max(result, map.size()+1);
            i++;
            j++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
