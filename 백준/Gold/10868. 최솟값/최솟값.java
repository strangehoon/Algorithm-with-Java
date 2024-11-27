import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] tree;

    public static long getMin(int a, int b){
        int minValue = Integer.MAX_VALUE;
        while (a<=b){
            if(a%2==1){
                minValue = Math.min(tree[a], minValue);
                a++;
            }
            if(b%2==0){
                minValue = Math.min(tree[b], minValue);
                b--;
            }
            a = a/2;
            b = b/2;
        }
        return minValue;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int height = 0;
        int tem = N;
        while (tem!=0){
            tem /= 2;
            height++;
        }

        int size = (int) Math.pow(2, height+1);
        int leftNodeStartIdx = size/2-1;
        tree = new int[size];

        Arrays.fill(tree, Integer.MAX_VALUE);

        for(int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+N; i++){
            tree[i] = Integer.valueOf(br.readLine());
        }

        while (size-1!=1){
            tree[(size-1)/2] = Math.min(tree[(size-1)/2], tree[size-1]);
            size--;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = a+leftNodeStartIdx;
            b = b+leftNodeStartIdx;
            bw.write(String.valueOf(getMin(a, b))+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}