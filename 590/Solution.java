import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(root, list);
        return list;
    }

    void traverse(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        for(Node child : node.children){
            traverse(child, list);
        }
        list.add(node.val);
    }

    public static void main(String args[]){
        Solution s = new Solution();
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

