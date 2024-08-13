import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node root;

    public static void DFS(Node node){
        if(node == null)
            return;

        if(node.left!=null)
            DFS(node.left);
        if(node.right!=null)
            DFS(node.right);
        System.out.println(node.value);
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        while(true){
            String tem = br.readLine();
            if(tem == null || tem.equals("")) break;
            else{
                int num = Integer.valueOf(tem);
                list.add(num);
            }
        }
        root = new Node(list.get(0));

        for(int i=1; i<list.size(); i++){
            int num = list.get(i);
            Node node = new Node(num);
            Node now = root;
            while(true){
                if(now.value<num){
                    if(now.right==null){
                        now.right = node;
                        break;
                    }
                    else
                        now = now.right;
                }
                else if(now.value>num){
                    if(now.left==null){
                        now.left = node;
                        break;
                    }
                    else
                        now = now.left;
                }
            }
        }
        DFS(root);

        bw.flush();
        bw.close();
        br.close();
    }
}