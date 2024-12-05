import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
            map.put(arr[i], 0);
        }

        for(int i=0; i<N; i++){
            int num = arr[i];
            for(int j=1; j<=Math.sqrt(num); j++){
                if(num%j!=0)
                    continue;
                int a = j;
                int b = num/j;
                if(a!=b){
                    if(map.containsKey(a)){
                        map.put(a, map.get(a)+1);
                        map.put(num, map.get(num)-1);
                    }
                    if(map.containsKey(b)){
                        map.put(b, map.get(b)+1);
                        map.put(num, map.get(num)-1);
                    }
                }
                else{
                    if(map.containsKey(a)){
                        map.put(a, map.get(a)+1);
                        map.put(num, map.get(num)-1);
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            bw.write(String.valueOf(map.get(arr[i]))+" ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}