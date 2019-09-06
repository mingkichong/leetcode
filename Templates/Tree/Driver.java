class Driver{
    public static void main(String args[]){
        int [][] nums = {{8},{12},{18},{1},{4},{7},{10},{5},{6},null,{3}};
        int [] nums2  = {8, 12, 18, 1, 4, 7, 10, 5, 6, 3};
        Integer [] nums3 = {8, 12, 18, 1, 4, 7, 10, 5, 6, null, 3};
        // int [][] nums = {null};
        System.out.println("BINARY TREE");
        TreeNode head = TreeNode.createBinaryTree(nums3);
        TreeNode.printWithOrder(head, TraverseOrder.PREORDER);
        TreeNode.printWithOrder(head, TraverseOrder.INORDER);
        TreeNode.printWithOrder(head, TraverseOrder.POSTORDER);
        TreeNode.printWithOrder(head, TraverseOrder.BFS);
        TreeNode.printTreeWithStructure(head);

        System.out.println();
        System.out.println("BINARY SEARCH TREE");
        head = TreeNode.createBinarySearchTree(nums);
        TreeNode.printWithOrder(head, TraverseOrder.PREORDER);
        TreeNode.printWithOrder(head, TraverseOrder.INORDER);
        TreeNode.printWithOrder(head, TraverseOrder.POSTORDER);
        TreeNode.printWithOrder(head, TraverseOrder.BFS);

        TreeNode.printTreeWithStructure(head);
    }
}
