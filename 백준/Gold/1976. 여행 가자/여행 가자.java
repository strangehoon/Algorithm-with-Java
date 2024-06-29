import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] arr;
    public static void Union(int a, int b){
        a = Find(a);
        b = Find(b);
        arr[b] = a;
    }

    public static int Find(int x){
        if(arr[x]==x)
            return arr[x];
        else
            return arr[x] = Find(arr[x]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.valueOf(st.nextToken());

        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int tem = Integer.valueOf(st.nextToken());
                if(tem==1){
                    Union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<M; i++){
            int x = Integer.valueOf(st.nextToken());
            set.add(Find(x));
        }
        if(set.size()==1)
            bw.write(String.valueOf("YES"));
        else
            bw.write(String.valueOf("NO"));
        bw.flush();
        bw.close();
        br.close();
    }
}