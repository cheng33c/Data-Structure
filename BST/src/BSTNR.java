import java.util.Stack;

// Binary Search Tree Not Recursion Version
public class BSTNR<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;
        Node (E e1) { e = e1; }
        @Override
        public String toString() { return e.toString(); }
    }

    private Node root;
    private int size;

    BSTNR() { root = null; size = 0; }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            return;
        }

        Node cur = root;
        for (; e.compareTo(cur.e) != 0;) {

            if (e.compareTo(cur.e) < 0 && cur.left == null) {
                cur.left = new Node(e);
                size ++;
                return;
            } else if(e.compareTo(cur.e) > 0 && cur.right == null) {// e.compareTo(cur.e) > 0
                cur.right = new Node(e);
                size ++;
                return;
            }

            if (e.compareTo(cur.e) < 0)
                cur = cur.left;
            else // e.compareTo(cur.e) > 0, 相等已经被for语句过滤了
                cur = cur.right;
        }
    }

    public boolean contains(E e) {
        Node cur = root;
        for (; e.compareTo(cur.e) != 0; ) {
            if ((e.compareTo(cur.e) < 0 && cur.left == null) ||
                    (e.compareTo(cur.e) > 0 && cur.right == null))
                return false;
            if (e.compareTo(cur.e) < 0)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return true;
    }

    public void preOrder() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for (; !stack.isEmpty(); ) {
            Node node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            System.out.println(node);
        }
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
}
