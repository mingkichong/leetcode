import java.util.*;

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<IndexedTreeNode>> map = new HashMap<>();
        traverse(root, map);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            ArrayList<IndexedTreeNode> nodes = map.get(key);
            Collections.sort(nodes);
            List<Integer> nodeValues = new ArrayList<>();
            for (IndexedTreeNode node : nodes) {
                nodeValues.add(node.node.val);
            }
            result.add(nodeValues);
        }
        return result;
    }

    private void traverse(TreeNode root, HashMap<Integer, ArrayList<IndexedTreeNode>> map) {
        LinkedList<IndexedTreeNode> queue = new LinkedList<>();
        queue.add(new IndexedTreeNode(root, 0, 0));
        while (queue.size() > 0) {
            IndexedTreeNode indexedNode = queue.poll();
            TreeNode node = indexedNode.node;
            int hIndex = indexedNode.hIndex;
            int vIndex = indexedNode.vIndex;
            if (!map.containsKey(vIndex)) {
                map.put(vIndex, new ArrayList<IndexedTreeNode>());
            }
            map.get(vIndex).add(indexedNode);
            if (node.left != null) {
                queue.add(new IndexedTreeNode(node.left, hIndex + 1, vIndex - 1));
            }
            if (node.right != null) {
                queue.add(new IndexedTreeNode(node.right, hIndex + 1, vIndex + 1));
            }
        }
    }

    private class IndexedTreeNode implements Comparable<IndexedTreeNode> {
        TreeNode node;
        int vIndex;
        int hIndex;
        IndexedTreeNode(TreeNode node, int hIndex, int vIndex) {
            this.node = node;
            this.hIndex = hIndex;
            this.vIndex = vIndex;
        }

        @Override
        public int compareTo(IndexedTreeNode o) {
            if (this.hIndex == o.hIndex) {
                return node.val - o.node.val;
            }
            return this.hIndex - o.hIndex;
        }

        @Override
        public String toString() {
            return "<" + node.val + "(h:" + hIndex + ", v:" + vIndex + ")>";
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.verticalTraversal(TreeNode.createBinaryTree(new Integer[] {3, 9, 20, null, null, 15, 7})));
        System.out.println(s.verticalTraversal(TreeNode.createBinaryTree(new Integer[] {1, 2, 3, 4, 5, 6, 7})));
        System.out.println(s.verticalTraversal(TreeNode.createBinaryTree(new Integer[] {0, 2, 1, 3, null, null, null, 4, 5, null, 7, 6, null, 10, 8, 11, 9})));
    }
}

