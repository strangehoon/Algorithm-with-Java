import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            sum += x;
            arr.add(x);
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        // 산술 평균
        System.out.println(Math.round((float)sum/N));

        // 중앙값
        Collections.sort(arr);
        System.out.println(arr.get(N/2));

        // 최빈값
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for(Integer x : map.keySet()){
            if(cnt < map.get(x)){
                cnt = map.get(x);
                result.clear();
                result.add(x);
            } else if (cnt == map.get(x)) {
                result.add(x);
            }
        }
        Collections.sort(result);
        if(result.size()>=2){
            System.out.println(result.get(1));
        }
        else{
            System.out.println(result.get(0));
        }

        // 범위
        System.out.println(arr.get(N-1)-arr.get(0));

        bw.flush();
        bw.close();
        br.close();
    }
}