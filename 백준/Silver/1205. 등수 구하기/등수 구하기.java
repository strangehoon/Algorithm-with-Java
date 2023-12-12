import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if(N==0){
            System.out.println(1);
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrayList.add(Integer.parseInt(st2.nextToken()));
        }

        // 존재 O
        if(arrayList.indexOf(X)!=-1){
            int index = arrayList.indexOf(X);
            if(index==P-1){
                System.out.println(-1);
                return;
            } else if (arrayList.lastIndexOf(X)==P-1) {
                System.out.println(-1);
                return;
            }
            System.out.println(index+1);
            return;
        }

        // 존재 X
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i)<X){
                System.out.println(i+1);
                return;
            }
        }
        if(N<P)
            System.out.println(N+1);
        else
            System.out.println(-1);
    }
}
