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

    public static TreeNode createBinaryTree(Integer[] n){
        int[][] nums = new int[n.length][];
        for(int i = 0; i < n.length; i++){
            if(n[i] != null){
                nums[i] = new int[]{n[i]};
            }
        }
        return createBinaryTree(nums);
    }

    public static TreeNode createBinaryTree(int[] n){
        int[][] nums = new int[n.length][1];
        for(int i = 0; i < nums.length; i++){
            nums[i] = new int[]{n[i]};
        }
        return createBinaryTree(nums);
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
            if(node == null){
                continue;
            }
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

    public static void printWithOrder(TreeNode node, TraverseOrder order){
        System.out.print("[");
        if(node == null){
            System.out.println("]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        traversePrint(node, order, list);
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
            if(i < list.size()-1){
                sb.append(", ");
            }
        }
        System.out.print(sb.toString());
        System.out.println("]");
    }

    private static void traversePrint(TreeNode node, TraverseOrder order, List<String> list){
        if(node == null){
            list.add("null");
            return;
        }
        switch(order){
            case BFS:
                printBFS(node, list);
                break;
            case PREORDER:
                list.add("" + node.val);
                traversePrint(node.left, order, list);
                traversePrint(node.right, order, list);
                break;
            case INORDER:
                traversePrint(node.left, order, list);
                list.add("" + node.val);
                traversePrint(node.right, order, list);
                break;
            case POSTORDER:
                traversePrint(node.left, order, list);
                traversePrint(node.right, order, list);
                list.add("" + node.val);
                break;
        }
    }

    private static void printBFS(TreeNode head, List<String> list){
        if(head == null){
            return;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(head);
        while(queue.size() > 0){
            TreeNode node = queue.remove(0);
            if(node == null){
                list.add("null");
            }
            else{
                list.add("" + node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }
}
