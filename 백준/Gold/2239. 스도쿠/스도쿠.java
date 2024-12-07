import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static java.lang.System.exit;

public class Main {

    public static int[][] graph;

    public static void dfs(int x, int y){

        if(x==9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(graph[i][j]);
                }
                System.out.println();
            }
            exit(0);
        }

        if(graph[x][y]==0){
            for(int i=1; i<=9; i++){
                if(check(x, y, i)){
                    graph[x][y] = i;
                    if(y+1<9){
                        dfs(x, y+1);
                    }
                    else{
                        dfs(x+1, 0);

                    }
                    graph[x][y] = 0;
                }
            }
        }
        else{
            if(y+1<9){
                dfs(x, y+1);
            }
            else{
                dfs(x+1, 0);
            }
        }
    }

    public static boolean check(int x, int y, int num){

        for(int i=0; i<9; i++){
            if(graph[x][i]==num){
                return false;
            }
            if(graph[i][y]==num){
                return false;
            }
        }

        int widthMok = x/3;
        int heigthMok = y/3;

        for(int i=widthMok*3; i<widthMok*3+3; i++){
            for(int j=heigthMok*3; j<heigthMok*3+3; j++){
                if(graph[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new int[9][9];
        for(int i=0; i<9; i++){
            String str = br.readLine();
            for(int j=0; j<9; j++){
                graph[i][j] = Integer.valueOf(str.charAt(j)-'0');
            }
        }
        dfs(0, 0);
        bw.flush();
        bw.close();
        br.close();
    }
}