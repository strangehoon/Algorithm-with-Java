import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static Node[] tree;
    public static List<Integer> orderList;
    public static boolean flag;

    public static class Node{
        int left;
        int right;

        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    public static void inOrder(int x){
        Node node = tree[x];
        int left = node.left;
        int right = node.right;

        if(left!=-1)
            inOrder(left);
        orderList.add(x);
        if(right!=-1)
            inOrder(right);
    }

    public static int newInOrder(int x, int cnt, int end){

        if(!flag)
            return cnt;

        Node node = tree[x];
        int left = node.left;
        int right = node.right;

        if(left!=-1)
            cnt = newInOrder(left, cnt+1, end);
        if(right!=-1)
            cnt = newInOrder(right, cnt+1, end);

        if(x==end){
            flag=false;
        }

        if(flag)
            return cnt+1;
        else
            return cnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        tree = new Node[n+1];
        orderList = new ArrayList<>();
        flag = true;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            tree[a] = new Node(b, c);
        }
        inOrder(1);
        
        int cnt = newInOrder(1, 0, orderList.get(orderList.size()-1));

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}