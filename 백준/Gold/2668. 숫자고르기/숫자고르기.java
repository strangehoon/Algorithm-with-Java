import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer;
    public static int[] arr;
    public static boolean[] visited;

    public static void dfs(int start, int init, List<Integer> answers){

        if(arr[start]==init){
            answers.add(init);
        }
        else{
            if(!visited[arr[start]]){
                visited[start] = true;
                dfs(arr[start], init, answers);
                visited[start] = false;
            }
        }


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }

        List<Integer> answers = new ArrayList<>();
        for(int i=1; i<=n; i++){
            visited[i] = true;
            dfs(i, i, answers);
            visited[i] = false;
        }
        Collections.sort(answers);
        System.out.println(answers.size());
        for(int x: answers)
            System.out.println(x);
    }
}