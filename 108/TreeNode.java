import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public enum TraverseOrder {
        INORDER, PREORDER, POSTORDER, BFS
    }


    /**************************************************************
     *  print and printWithOrder
     **************************************************************/
    public void print() {
        System.out.println(this.toString());
    }

    public static void print(TreeNode node) {
        System.out.println(node.toString());
    }

    public void printWithOrder(TraverseOrder order) {
        printWithOrder(this, order);
    }

    public static void printWithOrder(TreeNode node, TraverseOrder order) {
        StringBuilder sb = new StringBuilder();
        printWithOrder(node, order, sb);
        System.out.println(sb.toString());
    }

    private static void printWithOrder(TreeNode node, TraverseOrder order, StringBuilder sb) {
        sb.append("[");
        if (node == null) {
            sb.append("]");
            return;
        }
        ArrayList<String> list = new ArrayList<>();
        traversePrint(node, order, list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
    }

    private static void traversePrint(TreeNode node, TraverseOrder order, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }
        switch (order) {
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

    private static void printBFS(TreeNode head, List<String> list) {
        if (head == null) {
            return;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(head);
        while (queue.size() > 0) {
            TreeNode node = queue.remove(0);
            if (node == null) {
                list.add("null");
            } else {
                list.add("" + node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }


    /**************************************************************
     *  createBinarySearchTree
     **************************************************************/
    public static TreeNode createBinarySearchTree(int [][] nums) {
        if (isNull(nums)) {
            return null;
        }
        int count = 0;
        for (int [] N : nums) {
            if (N != null) {
                count++;
            }
        }
        int [] flatNums = new int[count];
        int i = 0;
        for (int [] N : nums) {
            if (N != null) {
                flatNums[i] = N[0];
                i++;
            }
        }
        return createBinarySearchTree(flatNums);
    }

    public static TreeNode createBinarySearchTree(Integer[] n) {
        int countNotNull = 0;
        for (Integer i : n) {
            if (i != null) {
                countNotNull++;
            }
        }
        int [] nums = new int[countNotNull];
        for (int i = 0, nI = 0; i < n.length; i++) {
            if (n[i] != null) {
                nums[nI++] = n[i];
            }
        }
        return createBinarySearchTree(nums);
    }

    public static TreeNode createBinarySearchTree(int [] nums) {
        if (isNull(nums)) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            addBinarySearchTreeNode(root, nums[i]);
        }
        return root;
    }

    private static void addBinarySearchTreeNode(TreeNode node, int num) {
        if (num < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(num);
            } else {
                addBinarySearchTreeNode(node.left, num);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(num);
            } else {
                addBinarySearchTreeNode(node.right, num);
            }
        }
    }


    /**************************************************************
     *  createBinaryTree
     **************************************************************/
    public static TreeNode createBinaryTree(Integer[] n) {
        int[][] nums = new int[n.length][];
        for (int i = 0; i < n.length; i++) {
            if (n[i] != null) {
                nums[i] = new int[] {n[i]};
            }
        }
        return createBinaryTree(nums);
    }

    public static TreeNode createBinaryTree(int[] n) {
        int[][] nums = new int[n.length][1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new int[] {n[i]};
        }
        return createBinaryTree(nums);
    }

    public static TreeNode createBinaryTree(int[][] nums) {
        if (isNull(nums)) {
            return null;
        }
        TreeNode [] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nodes.length; i++) {
            if (nums[i] == null) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(nums[i][0]);
            }
        }
        int index = 0;
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(nodes[index++]);
        while (queue.size() > 0) {
            TreeNode node = queue.remove(0);
            if (node == null) {
                continue;
            }
            if (index < nodes.length) {
                node.left = nodes[index++];
                queue.add(node.left);
            }
            if (index < nodes.length) {
                node.right = nodes[index++];
                queue.add(node.right);
            }
        }
        return nodes[0];
    }

    private static boolean isNull(int [][] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return false;
    }

    private static boolean isNull(int [] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return false;
    }


    /**************************************************************
     *  toString
     **************************************************************/
    @Override
    public String toString() {
        return BTreePrinter.printNode(this);
    }

    public String toString(TraverseOrder order) {
        switch (order) {
        case PREORDER:
            return getTreeWithStructurePreOrder(this);
        case INORDER:
            return getTreeWithStructureInOrder(this);
        default:
            return toString();
        }
    }

    public String toPrettyTreeString() {
        return toPrettyTreeString(this);
    }

    public static String toPrettyTreeString(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        prettyPrintTree(node,  "", true, sb);
        return sb.toString();
    }

    private static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft, StringBuilder sb) {
        if (node == null) {
            sb.append("Empty tree");
            sb.append("\n");
            return;
        }

        if (node.right != null) {
            prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false, sb);
        }

        sb.append(prefix + (isLeft ? "└── " : "┌── ") + node.val);
        sb.append("\n");

        if (node.left != null) {
            prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true, sb);
        }
    }

    private String getTreeWithStructureInOrder(TreeNode node) {
        if (node == null) {
            return "──NULL──";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("┌┐");
        sb.append("\n");
        printTreeWithStructureInOrder(node, "│╞", sb);
        sb.append("└┘");
        sb.append("\n\n");
        return sb.toString();
    }

    private void printTreeWithStructureInOrder(TreeNode node, String edge, StringBuilder sb) {
        if (node == null) {
            return;
        }
        printTreeWithStructureInOrder(node.left,  edge + "═══", sb);
        sb.append(edge + "╡");
        sb.append(node.val);
        sb.append("\n");
        printTreeWithStructureInOrder(node.right, edge + "═══", sb);
    }

    // https://www.baeldung.com/java-print-binary-tree-diagram
    private String getTreeWithStructurePreOrder(TreeNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);

        String pointerRight = "└──";
        String pointerLeft = (node.right != null) ? "├──" : "└──";

        traverseNodesWithStructurePreOrder(sb, "", pointerLeft, node.left, node.right != null);
        traverseNodesWithStructurePreOrder(sb, "", pointerRight, node.right, false);
        sb.append("\n\n");

        return sb.toString();
    }

    private void traverseNodesWithStructurePreOrder(StringBuilder sb, String padding, String pointer, TreeNode node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.val);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            traverseNodesWithStructurePreOrder(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodesWithStructurePreOrder(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    // https://www.inlumina.work/core-java/java-binary-tree-printer/
    private static class BTreePrinter {
        private static StringBuilder sb = null;
        public static <T extends Comparable<?>> String printNode(TreeNode root) {
            sb = new StringBuilder();
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
            return sb.toString();
        }

        private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes)) {
                return;
            }

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List<TreeNode> newNodes = new ArrayList<TreeNode>();
            for (TreeNode node : nodes) {
                if (node != null) {
                    print(node.val);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            println();

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null) {
                        print("/");
                    } else {
                        BTreePrinter.printWhitespaces(1);
                    }

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null) {
                        print("\\");
                    } else {
                        BTreePrinter.printWhitespaces(1);
                    }

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                println();
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++) {
                print(" ");
            }
        }

        private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
            if (node == null) {
                return 0;
            }

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null) {
                    return false;
                }
            }

            return true;
        }

        private static void print(int val) {
            print(String.valueOf(val));
        }

        private static void print(String str) {
            sb.append(str);
        }

        private static void println(int val) {
            println(String.valueOf(val));
        }

        private static void println(String str) {
            print(str);
            print("\n");
        }

        private static void println() {
            println("");
        }
    }


    /**************************************************************
     *  getNodeByVal
     **************************************************************/
    public static TreeNode getNodeByVal(TreeNode root, int val) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.val == val) {
                    return node;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return null;
    }


    /**************************************************************
     *  Serialise
     **************************************************************/
    public Integer[] serialise() {
        return TreeNode.serialise(this);
    }

    public static Integer[] serialise(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        if (node != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                TreeNode qNode = queue.poll();
                if (qNode != null) {
                    list.add(qNode.val);
                    queue.add(qNode.left);
                    queue.add(qNode.right);
                } else {
                    list.add(null);
                }
            }
            trimNulls(list);
        }
        return list.toArray(new Integer[list.size()]);
    }

    private static void trimNulls(LinkedList<Integer> list) {
        while (list.getFirst() == null) {
            list.removeFirst();
        }
        while (list.getLast() == null) {
            list.removeLast();
        }
    }
}
