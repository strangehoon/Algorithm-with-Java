import java.util.*;
class Solution {
    class Node implements Comparable<Node>{
        int num;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node n){
            if(this.y==n.y)
                return n.x-this.x;
            else
                return n.y-this.y;
        }
    }
    
    public void makeTree(Node pre, Node now){
        if(pre.x<now.x){
            if(pre.right == null)
                pre.right = now;
            else
                makeTree(pre.right, now);
        }
        else{
            if(pre.left == null)
                pre.left = now;
            else
                makeTree(pre.left, now);
        }
    }
    
        public void preorder(Node node, List<Integer> list){
        list.add(node.num);
        if(node.left!=null)
            preorder(node.left, list);
        if(node.right!=null)
            preorder(node.right, list);
    }
    
    public void postorder(Node node, List<Integer> list){
        if(node.left!=null)
            postorder(node.left, list);
        if(node.right!=null)
            postorder(node.right, list);
        list.add(node.num);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<nodeinfo.length; i++){
            int[] node = nodeinfo[i];
            pq.offer(new Node(i+1, node[0], node[1]));
        }
        
        Node root = pq.poll();
        while(!pq.isEmpty()){
            Node now = pq.poll();
            makeTree(root, now);
        }
        
        int[][] answers = new int[2][nodeinfo.length];
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();
        preorder(root, preOrderList);
        postorder(root, postOrderList);
        
        for(int i=0; i<nodeinfo.length; i++){
            answers[0][i] = preOrderList.get(i);
            answers[1][i] = postOrderList.get(i);
        }
        
        return answers;
    }
}