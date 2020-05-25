import java.util.Arrays;

class Driver{
    public static void main(String args[]){
        int [][] nums = {{8},{12},{18},{1},{4},{7},{10},{5},{6},null,{3}};
        int [] nums2  = {8, 12, 18, 1, 4, 7, 10, 5, 6, 3};
        Integer [] nums3 = {8, 12, 18, 1, 4, 7, 10, 5, 6, null, 3};
        // int [][] nums = {null};
        System.out.println("BINARY TREE");
        TreeNode head = TreeNode.createBinaryTree(nums3);
        TreeNode.printWithOrder(head, TreeNode.TraverseOrder.PREORDER);
        TreeNode.printWithOrder(head, TreeNode.TraverseOrder.INORDER);
        TreeNode.printWithOrder(head, TreeNode.TraverseOrder.POSTORDER);
        TreeNode.printWithOrder(head, TreeNode.TraverseOrder.BFS);

        TreeNode.print(head);
        head.print();
        System.out.println(head);

        System.out.println();
        System.out.println("BINARY SEARCH TREE");
        head = TreeNode.createBinarySearchTree(nums);
        TreeNode.printWithOrder(head, TreeNode.TraverseOrder.PREORDER);
        TreeNode.printWithOrder(head, TreeNode.TraverseOrder.INORDER);
        TreeNode.printWithOrder(head, TreeNode.TraverseOrder.POSTORDER);
        TreeNode.printWithOrder(head, TreeNode.TraverseOrder.BFS);

        TreeNode.print(head);
        head.print();
        System.out.println(head);
        System.out.println(head.toString(TreeNode.TraverseOrder.INORDER));
        System.out.println(head.toString(TreeNode.TraverseOrder.PREORDER));

        head = TreeNode.createBinaryTree(nums3);
        for(int i = 0; i < 10; i++){
            Integer [] serialised = TreeNode.serialise(head);
            head = TreeNode.createBinaryTree(serialised);
        }
        System.out.println(head);
    }
}
