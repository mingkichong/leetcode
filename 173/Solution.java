import java.util.*;

class Solution {

    public static void main(String args[]) {
        Solution s = new Solution();
        printIterator(new BSTIterator(TreeNode.createBinaryTree(new Integer[] {7, 3, 15, null, null, 9, 20})));
        Random random = new Random(1010101);
        for (int i = 0; i < 20; i++) {
            printIterator(new BSTIterator(TreeNode.createBinarySearchTree(getRandomIntArray(random))));
        }
    }

    private static int[] getRandomIntArray(Random random) {
        int [] array = new int[random.nextInt(20) + 5];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length) + 1;
        }
        return array;
    }

    private static void printIterator(BSTIterator iterator) {
        System.out.println("maxStackSize: " + getMaxStackSize(iterator.getRoot()));
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
        System.out.println(iterator.getRoot());
        System.out.println();
    }

    private static int getMaxStackSize(TreeNode root) {
        BSTIterator iterator = new BSTIterator(root);
        int max = 0;
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.getStackSize());
            iterator.next();
        }
        return max;
    }

    static class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;

        public BSTIterator(TreeNode root) {
            this.root = root;
            TreeNode node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode root = stack.pop();
            int val = root.val;

            if (root.right != null) {
                TreeNode node = root.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            return val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public TreeNode getRoot() {
            return root;
        }

        public int getStackSize() {
            return stack.size();
        }
    }
}
