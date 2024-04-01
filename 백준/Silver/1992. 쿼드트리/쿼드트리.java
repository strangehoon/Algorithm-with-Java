import java.io.*;
public class Main {
    static int N;
    static int[][] graph;

    public static String Recur(int x1, int y1, int n){

        if(n==1){
            return String.valueOf(graph[x1][y1]);
        }

        String tem[] = new String[6];
        tem[0] = "(";
        tem[5] = ")";

        // 1사
        String flag1 = Recur(x1, y1, n/2);
        tem[1] = flag1;

        // 2사
        String flag2 = Recur(x1, y1+n/2, n/2);
        tem[2] = flag2;

        // 3사
        String flag3 = Recur(x1+n/2, y1, n/2);
        tem[3] = flag3;

        // 4사
        String flag4 = Recur(x1+n/2, y1+n/2, n/2);
        tem[4] = flag4;

        if(flag1.equals("1") || flag1.equals("0")){
            if(flag1.equals(flag2) && flag2.equals(flag3) && flag3.equals(flag4)){
                return flag1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String a : tem){
            sb.append(a);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.valueOf(str.charAt(j)-'0');
            }
        }
        System.out.println(Recur(0, 0, N));

        bw.flush();
        bw.close();
        br.close();
    }
}