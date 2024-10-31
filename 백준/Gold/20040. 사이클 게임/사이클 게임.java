import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] arr;

    public static int Find(int v){
        if(arr[v]==v){
            return v;
        }
        else{
            return arr[v] = Find(arr[v]);
        }
    }

    public static void Union(int v1, int v2) {

        v1 = Find(v1);
        v2 = Find(v2);

        if (v1 > v2)
            arr[v1] = v2;
        else
            arr[v2] = v1;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i;
        }
        boolean flag = false;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());

            if(Find(v1)==Find(v2)){
                bw.write(String.valueOf(i+1));
                flag = true;
                break;
            }
            else{
                Union(v1 , v2);
            }
        }
        if(!flag)
            bw.write(String.valueOf(0));

        bw.flush();
        bw.close();
        br.close();
    }
}
