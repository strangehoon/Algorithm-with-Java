import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    public static int[][] graph;

    public static void Dfs(int x, int y){

        if(x==0 && y==9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(graph[i][j] +" ");
                }
                System.out.println();
            }
            exit(0);
        }

        if(graph[x][y]==0){
            for(int k=1; k<=9; k++){
                if(Check(x, y, k)){
                    graph[x][y] = k;
                    if(x<8){
                        Dfs(x+1, y);
                    }
                    else{
                        Dfs(0, y+1);
                    }
                    graph[x][y] = 0;
                }
            }
        }
        else{
            if(x<8){
                Dfs(x+1, y);
            }
            else{
                Dfs(0, y+1);
            }
        }
    }

    public static boolean Check(int x, int y, int z){

        boolean flag = true;
        for(int i=0; i<9; i++){
            if(graph[x][i]==z){
                flag = false;
                break;
            }
            if(graph[i][y]==z){
                flag = false;
                break;
            }
        }

        int temx=x/3;
        int temy=y/3;
        for(int j=temx*3; j<(temx+1)*3; j++){
            for(int k=temy*3; k<(temy+1)*3; k++){
                if(graph[j][k]==z){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new int[9][9];

        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                graph[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        Dfs(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }
}