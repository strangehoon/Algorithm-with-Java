import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static int[][] arr;

    public static void preOrder(int x){
        if(x==-1)
            return;
        System.out.print((char)(x+'A'));
        preOrder(arr[x][0]);
        preOrder(arr[x][1]);
    }

    public static void inOrder(int x){
        if(x==-1)
            return;
        inOrder(arr[x][0]);
        System.out.print((char)(x+'A'));
        inOrder(arr[x][1]);
    }

    public static void postOrder(int x){
        if(x==-1)
            return;
        postOrder(arr[x][0]);
        postOrder(arr[x][1]);
        System.out.print((char)(x+'A'));
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        arr = new int[26][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0)-'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left=='.')
                arr[node][0] = -1;
            else
                arr[node][0] = left-'A';
            if(right=='.')
                arr[node][1] = -1;
            else
                arr[node][1] = right-'A';
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);

        bw.flush();
        bw.close();
        br.close();
    }
}