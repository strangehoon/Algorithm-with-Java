import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] tree;
    public static int[] arr;
    public static int leftNodeStartIdx;

    public static long getMax(int start, int end) {
        int m = query(start, end);

        long area = (end - start + 1) * (long)arr[m];

        if (start <= m - 1) {
            long tmp = getMax(start, m - 1);
            area = Math.max(area, tmp);
        }

        if (m + 1 <= end) {
            long tmp = getMax(m + 1, end);
            area = Math.max(area, tmp);
        }

        return area;
    }

    public static int query(int a, int b){
        int minIdx = a;
        int minHeight = arr[minIdx];

        a += leftNodeStartIdx;
        b += leftNodeStartIdx;

        while (a<=b){
            if(a%2==1){
                if(minHeight>arr[tree[a]]) {
                    minIdx = tree[a];
                    minHeight = arr[minIdx];
                }
                a++;
            }
            if(b%2==0){
                if(minHeight>arr[tree[b]]){
                    minIdx = tree[b];
                    minHeight = arr[minIdx];
                }
                b--;
            }
            a = a/2;
            b = b/2;
        }
        return minIdx;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.valueOf(st.nextToken());
            if(N==0)
                break;
            arr = new int[N+1];
            for(int i=1; i<=N; i++){
                arr[i] = Integer.valueOf(st.nextToken());
            }
            arr[0] = Integer.MAX_VALUE;

            int height = 0;
            int tem = N;
            while (tem!=0){
                tem /= 2;
                height++;
            }

            int size = (int) Math.pow(2, height+1);
            leftNodeStartIdx = size/2-1;
            tree = new int[size];

            for(int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+N; i++){
                tree[i] = i-leftNodeStartIdx;
            }

            while (size-1!=1){
                int a = tree[size-1];
                int b = tree[(size-1)/2];
                if(arr[a]<arr[b]) {
                    tree[(size-1)/2] = tree[size-1];
                }
                size--;
            }

            bw.write(String.valueOf(getMax(1, N))+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}