import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> list;
    static int[]tem;
    static List<Integer> result;
    static void DFS(int index, int cnt){
        if(cnt>=3){
            int sum=0;
            for(int i=0; i<3; i++){
                sum+=tem[i];
            }
            result.add(sum);
        }
        else {
            for (int i = index; i < list.size(); i++) {
                tem[cnt] = list.get(i);
                DFS(index, cnt + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        tem = new int[3];
        result = new ArrayList<>();
        list = new ArrayList<>();
        int i=1;
        while (true){
            int x = i*(i+1)/2;
            if(x>1000)
                break;
            list.add(x);
            i++;
        }
        DFS(0,0);
        for(int j=0;j<N;j++){
            int x = Integer.parseInt(br.readLine());
            if(result.contains(x)){
                bw.write(String.valueOf(1 +"\n"));
            }
            else
                bw.write(String.valueOf(0 + "\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
