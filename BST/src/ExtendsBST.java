public class ExtendsBST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;
        public int size, depth, count;
        public Node(E e) { this.e = e; size = 1; count = 1; depth = 1; }
        @Override
        public String toString() { return e.toString(); }
    }

    private Node root;
    private int size;

    public ExtendsBST() { root = null; size = 0; }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            return;
        }

        Node cur = root;
        for (;;) {
            int cmp = e.compareTo(cur.e);
            if (cmp == 0) {
                cur.count++;
                break;
            }
            if (cmp < 0 && cur.left == null) {
                cur.left = new Node(e);
                size ++;
                return;
            } else if(cmp > 0 && cur.right == null) {// e.compareTo(cur.e) > 0
                cur.right = new Node(e);
                size ++;
                return;
            }

            if (cmp < 0)
                cur = cur.left;
            else // cmp > 0, 相等已经被for语句过滤了
                cur = cur.right;
            cur.size ++;
            cur.depth ++;
        }
    }

    public E floor(E e) {
        Node minNode = floor(root, e);
        return minNode == null ? null : minNode.e;

    }
    private Node floor(Node node, E e) {
        // 中序遍历得到最接近且比e小的节点
        if (node == null)
            return null;

        int cmp = e.compareTo(node.e);
        if (cmp == 0)
            return node;
        if (cmp < 0)
            return floor(node.left, e);
        Node rightNode = floor(node.right, e);
        if (rightNode != null)
            return rightNode;
        else
            return node;
    }

    public E ceil(E e) {
        Node maxNode = ceil(root, e);
        return maxNode == null ? null : maxNode.e;
    }
    private Node ceil(Node node, E e) {
        if (node == null)
            return null;

        int cmp = e.compareTo(node.e);
        if (cmp == 0)
            return node;
        if (cmp > 0)
            return ceil(node.right, e);
        Node leftNode = ceil(node.left, e);
        if (leftNode != null)
            return leftNode;
        else
            return node;
    }


    public int rank(E e) {
        return rank(root, e);
    }
    private int rank(Node node, E e) {
        if (node == null)
            return 0;
        int cmp = e.compareTo(node.e);
        int leftSize = node.left == null ? 0 : node.left.size;
        if (cmp == 0)
            return leftSize + 1;
        else if (cmp > 0)
            return leftSize + 1 + rank(node.right, e);
        else// cmp < 0
            return rank(node.left, e);
    }



    public E select(int rank) {
        if (rank >= size)
            throw new IllegalArgumentException(
                    String.format("select failed; rank out of bound; SIZE=%d, RANK=%d", size, rank));
        return select(root, rank).e;
    }
    private Node select(Node node, int rank) {
        if (node == null)
            return null;
        int t = node.left == null ? 0 : node.left.size;
        if (t > rank)
            return select(node.left, rank);
        else if (t < rank)
            return select(node.right, rank - t - 1);
        else
            return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    // 生成以node为节点,深度为depth的描述二叉树字符串
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1 , sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i ++)
            sb.append("--");
        return sb.toString();
    }

    public static void main(String[] args) {
        ExtendsBST<Integer> bst = new ExtendsBST<>();
        int[] nums = {5, 10, 20, 13, 56, 31, 88, 62, 19};
        for (int i = 0; i < nums.length; i ++)
            bst.add(nums[i]);
        bst.add(5);
        System.out.println(bst);
        //System.out.println(bst.floor(21));
        //System.out.println(bst.ceil(21));
//        System.out.println(bst.rank(56));
//        System.out.println(bst.rank(88));
//        System.out.println(bst.rank(2000));
        //System.out.println(bst.select(3));
    }

}
