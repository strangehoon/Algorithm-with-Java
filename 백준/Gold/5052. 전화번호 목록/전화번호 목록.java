import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static class Node{
        Node[] arr = new Node[10];
        boolean isEnd;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.valueOf(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            Node root = new Node();
            boolean flag = true;
            for(int i=0; i<n; i++){
                String str = br.readLine();
                Node now = root;
                for(int j=0; j<str.length(); j++){
                    int v = str.charAt(j)-'0';
                    if(now.isEnd){
                        flag = false;
                        break;
                    }

                    if(now.arr[v]==null){
                        now.arr[v] = new Node();
                        now = now.arr[v];
                    }
                    else{
                        now = now.arr[v];
                    }
                }
                now.isEnd = true;
                for(int j=0; j<10; j++){
                    if(now.arr[j]!=null){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag==false)
                bw.write("NO\n");
            else
                bw.write("YES\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}