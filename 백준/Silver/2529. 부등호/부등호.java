import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String[] arr;
    static int N;
    static boolean[] visited;
    static List<String> results;
    public static void Sol(int idx, int predix, String str){

        if(idx==N+1){
            results.add(str);
        }
        else{
            for(int i=0; i<=9; i++){
                if(idx==0){
                    visited[i] = true;
                    Sol(idx+1, i, str+i);
                    visited[i] = false;
                }
                else if(visited[i]==false){
                    if(arr[idx-1].equals(">")){
                        if(predix>i){
                            visited[i] = true;
                            Sol(idx+1, i, str+i);
                            visited[i] = false;
                        }
                    }
                    else if(arr[idx-1].equals("<")){
                        if(predix<i){
                            visited[i] = true;
                            Sol(idx+1, i, str+i);
                            visited[i] = false;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        arr = str.split(" ");
        visited = new boolean[10];
        results = new ArrayList<>();

        Sol(0, -1, "");

        bw.write(String.valueOf(results.get(results.size()-1))+"\n");
        bw.write(String.valueOf(results.get(0))+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}