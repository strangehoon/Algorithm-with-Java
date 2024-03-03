import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x<=0){
                minus.add(x);
            }
            else {
                pos.add(x);
            }
        }
        Collections.sort(minus);
        Collections.sort(pos, Collections.reverseOrder());
        int result=0;

        // minus list
        for(int i=0; i<minus.size()/2; i++){
            result += minus.get(2*i)*minus.get(2*i+1);
        }
        if(minus.size()%2==1){
            result += minus.get(minus.size()-1);
        }

        // plus list
        for(int i=0; i< pos.size()/2; i++){
            if(pos.get(2*i)==1 || pos.get(2*i+1)==1)
                result += pos.get(2*i)+pos.get(2*i+1);
            else
                result += pos.get(2 * i) * pos.get(2 * i + 1);
        }
        if(pos.size()%2==1) {
            result += pos.get(pos.size() - 1);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}