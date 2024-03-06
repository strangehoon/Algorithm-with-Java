import java.io.*;
import java.util.*;

public class Main {
    static boolean[] result;
    static int A,B,C;
    static boolean[][] visited;
    static int[] max_water;

    public static void DFS(int a, int b, int c){

        if(a==0 && result[c]==false){
            result[c]= true;
        }

        // a->b
        if(a+b<=B && visited[0][a+b]==false){
            visited[0][a+b]=true;
            DFS(0, a+b, c);
            visited[0][a+b]=false;
        } else if (a+b>B && visited[a+b-B][B]==false) {
            visited[a+b-B][B]=true;
            DFS(a+b-B, B, c);
            visited[a+b-B][B]=false;
        }

        // a->c
        if(a+c<=C && visited[0][b]==false){
            visited[0][b]=true;
            DFS(0, b, a+c);
            visited[0][b]=false;
        } else if (a+c>C && visited[a+c-C][b]==false) {
            visited[a+c-C][b]=true;
            DFS(a+c-C, b, C);
            visited[a+c-C][b]=false;
        }

        // b->a
        if(b+a<=A && visited[b+a][0]==false){
            visited[b+a][0]=true;
            DFS(b+a,0,c);
            visited[b+a][0]=false;
        } else if (b+a>A && visited[A][a+b-A]==false) {
            visited[A][a+b-A]=true;
            DFS(A,a+b-A,c);
            visited[A][a+b-A]=false;
        }

        //b->c
        if(b+c<=C && visited[a][0]==false){
            visited[a][0]=true;
            DFS(a, 0, b+c);
            visited[a][0]=false;
        } else if (b+c>C && visited[a][b+c-C]==false) {
            visited[a][b+c-C]=true;
            DFS(a, b+c-C, C);
            visited[a][b+c-C]=false;
        }

        // c->a
        if(c+a<=A && visited[a+c][b]==false){
            visited[a+c][b]=true;
            DFS(a+c,b,0);
            visited[a+c][b]=false;
        } else if (a+c>A && visited[A][b]==false) {
            visited[A][b]=true;
            DFS(A,b,a+c-A);
            visited[A][b]=false;
        }

        // c->b
        if(c+b<=B && visited[a][b+c]==false){
            visited[a][b+c]=true;
            DFS(a,b+c,0);
            visited[a][b+c]=false;
        } else if (c+b>B && visited[a][B]==false) {
            visited[a][B]=true;
            DFS(a, B, b+c-B);
            visited[a][B]=false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max_water = new int[3];
        max_water[0] = A;
        max_water[1] = B;
        max_water[2] = C;
        visited = new boolean[A+1][B+1];
        result = new boolean[C+1];
        visited[0][0] = true;
        DFS(0, 0, C);

        for(int i=0; i<=C; i++){
            if(result[i]==true)
                bw.write(String.valueOf(i)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}