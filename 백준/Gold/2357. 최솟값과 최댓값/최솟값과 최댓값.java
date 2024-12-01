import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] maxTree;
    public static int[] minTree;

    public static int getMax(int s, int e){
        int maxValue = 0;
        while (s<=e){
            if(s%2==1){
                maxValue = Math.max(maxValue, maxTree[s]);
                s++;
            }
            if(e%2==0){
                maxValue = Math.max(maxValue, maxTree[e]);
                e--;
            }
            s = s/2;
            e = e/2;
        }
        return maxValue;
    }

    public static int getMin(int s, int e){
        int minValue = Integer.MAX_VALUE;
        while (s<=e){
            if(s%2==1){
                minValue = Math.min(minValue, minTree[s]);
                s++;
            }
            if(e%2==0){
                minValue = Math.min(minValue, minTree[e]);
                e--;
            }
            s = s/2;
            e = e/2;
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
        minTree = new int[size];
        maxTree = new int[size];

        Arrays.fill(minTree, Integer.MAX_VALUE);


        for(int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+N; i++){
            minTree[i] = Integer.valueOf(br.readLine());
            maxTree[i] = minTree[i];
        }

        while (size-1!=1){
            minTree[(size-1)/2] = Math.min(minTree[(size-1)/2], minTree[size-1]);
            maxTree[(size-1)/2] = Math.max(maxTree[(size-1)/2], maxTree[size-1]);
            size--;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            a = a+leftNodeStartIdx;
            b = b+leftNodeStartIdx;
            bw.write(String.valueOf(getMin(a, b))+" ");
            bw.write(String.valueOf(getMax(a, b))+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}