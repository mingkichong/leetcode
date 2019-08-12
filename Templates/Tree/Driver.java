class Driver{
    public static void main(String args[]){
        int [][] nums = {{10},{5},{15},{3},{7},{13},{18},{1},null,{6}};
        TreeNode head = TreeNode.createList(nums);
        TreeNode.printWithOrder(head, TraverseOrder.PREORDER);
        TreeNode.printBFS(head);
    }
}
