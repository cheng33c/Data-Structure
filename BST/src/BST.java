import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public Node left, right;
        public E e;
        Node(E e1) { e = e1; left = right = null; }
        @Override
        public String toString() { return e.toString(); }
    }

    private Node root;
    private int size;

    public BST() { root = null; size = 0; }

    public void add(E e) {
        root = add(root, e);
    }
    private Node add(Node node, E e) {
        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }



    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        return e.compareTo(node.e) < 0 ? contains(node.left, e) : contains(node.right, e);
    }



    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // preOrderNotRecursion 前序遍历非递归实现
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();

            System.out.println(node);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node);
            inOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node);
        }
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
            System.out.println(cur);
        }
    }

    // 寻找最小元素
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }
    private Node minimum(Node node) {
        return node.left == null ? node : minimum(node.left);
    }

    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root).e;
    }
    private Node maximum(Node node) {
        return node.right == null ? node : maximum(node.right);
    }


    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    public void remove(E e) {
        root = remove(root, e);
    }
    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e.compareTo(node.e) == 0
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            } else { // node.left != null && node.right != null
//                Node successor = minimum(node.right);
//                successor.left = node.left;
//                successor.right = removeMin(node.right);
//                node.left = node.right = null;
                node.e = minimum(node.right).e;
                node.right = removeMin(node.right);
                return node;
            }
        }

    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

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
