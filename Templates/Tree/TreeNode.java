import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode createList(int[][] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length == 1 && nums[0] == null){
            return null;
        }
        TreeNode [] nodes = new TreeNode[nums.length];
        for(int i = 0; i < nodes.length; i++){
            if(nums[i] == null){
                nodes[i] = null;
            }
            else{
                nodes[i] = new TreeNode(nums[i][0]);
            }
        }
        int index = 0;
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(nodes[index++]);
        while(queue.size() > 0){
            TreeNode node = queue.remove(0);
            if(index < nodes.length){
                node.left = nodes[index++];
                queue.add(node.left);
            }
            if(index < nodes.length){
                node.right = nodes[index++];
                queue.add(node.right);
            }
        }
        return nodes[0];
    }

    public static void printBFS(TreeNode head){
        System.out.print("[");
        if(head == null){
            System.out.println("]");
            return;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(head);
        while(queue.size() > 0){
            TreeNode node = queue.remove(0);
            System.out.print(node.val);
            System.out.print(", ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        System.out.println("]");
    }

    public static void printWithOrder(TreeNode node, TraverseOrder order){
        System.out.print("[");
        if(node == null){
            System.out.println("]");
            return;
        }
        traversePrint(node, order);
        System.out.println("]");
    }

    static void traversePrint(TreeNode node, TraverseOrder order){
        if(node == null){
            return;
        }
        switch(order){
            case PREORDER:
                System.out.print(node.val);
                System.out.print(", ");
                traversePrint(node.left, order);
                traversePrint(node.right, order);
                break;
            case INORDER:
                traversePrint(node.left, order);
                System.out.print(node.val);
                System.out.print(", ");
                traversePrint(node.right, order);
                break;
            case POSTORDER:
                traversePrint(node.left, order);
                traversePrint(node.right, order);
                System.out.print(node.val);
                System.out.print(", ");
                break;
        }
    }
}
