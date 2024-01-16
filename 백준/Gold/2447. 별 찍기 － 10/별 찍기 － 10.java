import java.io.*;
public class Main {

    static char[][] graph;

    public static void Star(int x, int y, int n){
        if(n==3){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==1 && j==1)
                        continue;
                    graph[x+i][y+j] = '*';
                }
            }
        }
        else {
            int tem = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1)
                        continue;
                    Star(x + i * tem, y + j * tem, tem);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                graph[i][j] = ' ';
            }
        }

        // function call
        Star(0, 0, N);

        // output
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(String.valueOf(graph[i][j]));
            }
            bw.write(String.valueOf("\n"));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}