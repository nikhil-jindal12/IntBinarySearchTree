public class BinarySearchTree {
    private Node root;
    private static int nodeCount;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static void insert(Node root, int value) {
        Node parent = null;
        Node trav = root;
        nodeCount++;

        while (trav != null) {
            parent = trav;
            if (value < trav.getKey()) {
                trav = trav.getLeft();
            } else {
                trav = trav.getRight();
            }
        }

        if (parent == null) {
            root = new Node(value);
        } else if (value < parent.getKey()) {
            parent.setLeft(new Node(value));
        } else {
            parent.setRight(new Node(value));
        } 
    
    }

    public static void preorderRec(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getKey() + " ");
        preorderRec(root.getLeft());

        preorderRec(root.getRight());

    }

    public int sum(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.getKey() + sum(root.getLeft()) + sum(root.getRight());
        }
    }

    // finds the Node that is the kth biggest Node of the entire BinarySearchTree
    public static Node kthBiggest(Node root, int k) throws IndexOutOfBoundsException {        
        if (k > nodeCount) {
            throw new IndexOutOfBoundsException();
        }

        return reverseInorderRec(root, k);

    }

    private static Node reverseInorderRec(Node root, int k) {
        if (root == null || k == 0) {
            return null;
        }
        
        while (k > 0) {
            // Recursively traverse the right subtree first
            reverseInorderRec(root.getRight(), k);
            if (root.getRight() != null) {
                k--;
            }
            
            
            // Continue with the left subtree
            reverseInorderRec(root.getLeft(), k);
            if (root.getLeft() != null) {
                k--;
            }
            
            return root;
            
        }

        return root;

    }
    

    public static void main(String[] args) {
        Node root = new Node(5);
        insert(root, 3);
        insert(root, 7);
        insert(root, 2);
        insert(root, 4);
        insert(root, 6);
        insert(root, 8);


        // System.out.println(root.getLeft().getRight().getRight().getRight().getKey());
        System.out.println(root.getRight().getLeft().getKey());
        System.out.println(kthBiggest(root, 3).getKey());
        // preorderRec(root);
    }
    

}
