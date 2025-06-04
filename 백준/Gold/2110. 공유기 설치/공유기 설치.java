import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            list.add(x);
        }
        Collections.sort(list);

        int idx = 1;
        int jdx = 1000000000;
        int answer = 0;
        while(idx<=jdx){
            int mid = (idx+jdx)/2;
            int preIdx = 0;
            int cnt = 1;
            for(int i=1; i<N; i++){
                if(list.get(i)-list.get(preIdx)>=mid){
                    cnt ++;
                    preIdx = i;
                }
            }
            if(cnt>=C){
                idx = mid+1;
                answer = Math.max(answer, mid);
            }
            else{
                jdx = mid-1;
            }
        }
        System.out.println(answer);
    }
}