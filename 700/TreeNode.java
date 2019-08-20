import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    private static boolean isNull(int [][] nums){
        if(nums == null || nums.length == 0){
            return true;
        }
        return false;
    }

    public static TreeNode createBinarySearchTree(int [][] nums){
        if(isNull(nums)){
            return null;
        }
        int count = 0;
        for(int [] N : nums){
            if(N != null){
                count++;
            }
        }
        int [] flatNums = new int[count];
        int i = 0;
        for(int [] N : nums){
            if(N != null){
                flatNums[i] = N[0];
                i++;
            }
        }
        return createBinarySearchTree(flatNums);
    }

    public static TreeNode createBinarySearchTree(int [] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        for(int i = 1; i < nums.length; i++){
            addBinarySearchTreeNode(root, nums[i]);
        }
        return root;
    }

    private static void addBinarySearchTreeNode(TreeNode node, int num){
        if(num < node.val){
            if(node.left == null){
                node.left = new TreeNode(num);
            }
            else{
                addBinarySearchTreeNode(node.left, num);
            }
        }
        else{
            if(node.right == null){
                node.right = new TreeNode(num);
            }
            else{
                addBinarySearchTreeNode(node.right, num);
            }
        }
    }

    public static TreeNode createBinaryTree(int[][] nums){
        if(isNull(nums)){
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
        StringBuilder sb = new StringBuilder();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(head);
        while(queue.size() > 0){
            TreeNode node = queue.remove(0);
            sb.append(node.val);
            sb.append(", ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
        System.out.println("]");
    }

    public static void printWithOrder(TreeNode node, TraverseOrder order){
        if(order == TraverseOrder.BFS){
            printBFS(node);
            return;
        }
        System.out.print("[");
        if(node == null){
            System.out.println("]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        traversePrint(node, order, sb);
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
        System.out.println("]");
    }

    private static void traversePrint(TreeNode node, TraverseOrder order, StringBuilder sb){
        if(node == null){
            return;
        }
        switch(order){
            case PREORDER:
                sb.append(node.val);
                sb.append(", ");
                traversePrint(node.left, order, sb);
                traversePrint(node.right, order, sb);
                break;
            case INORDER:
                traversePrint(node.left, order, sb);
                sb.append(node.val);
                sb.append(", ");
                traversePrint(node.right, order, sb);
                break;
            case POSTORDER:
                traversePrint(node.left, order, sb);
                traversePrint(node.right, order, sb);
                sb.append(node.val);
                sb.append(", ");
                break;
        }
    }
}
