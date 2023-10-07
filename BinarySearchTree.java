import java.util.List;
import java.util.ArrayList;

/**
 * Class and relevant methods for a Binary Search Tree (BST) that contains integer keys
 * @author Nikhil Jindal
 */
public class BinarySearchTree {

    // instance field that stores the root of the BST
    private Node root;

    // instance field that counts the number of nodes in the BST as they are inserted
    private int nodeCount;

    // Constructor for the BST class
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Returns the root of the BST
     * @return the root of the BST
     */
    public Node getRoot() {
        return this.root;
    }

    /**
     * Returns the number of nodes in the BST
     * @return
     */
    public int getNodeCount() {
        return this.nodeCount;
    }

    /**
     * Inserts a node into the BST based on the value given
     * @param root  the root of the BST
     * @param value  the key which determines where the node will be placed into the BST
     */
    public void insert(Node root, int value) {
        Node parent = null;
        Node trav = root;
        
        // traverse the BST until a leaf node is reached
        while (trav != null) {
            parent = trav;
            if (value < trav.getKey()) {
                trav = trav.getLeft();
            } else {
                trav = trav.getRight();
            }
        }
        
        // insert the node into the BST based on the value of its key and in correspondence with its parent node
        if (parent == null) {
            root = new Node(value);
        } else if (value < parent.getKey()) {
            parent.setLeft(new Node(value));
        } else {
            parent.setRight(new Node(value));
        } 
        
        // increment the node count
        nodeCount++;

    }

    /**
     * Recursive method that prints the preorder traversal of the BST
     * @param root  the root of the BST
     */
    public void preorderRec(Node root) {
        
        // base case
        if (root == null) {
            return;
        }

        // recursive case:

        // traverses the left subtree of a node
        preorderRec(root.getLeft());

        // traverses the right subtree of a node
        preorderRec(root.getRight());

    }

    /**
     * Recursive method that returns the sum of all the keys in the BST
     * @param root  the root of the BST
     * @return  the sum of all the keys in the BST
     */
    public int sum(Node root) {
        
        if (root == null) {

            // base case
            return 0;

        } else {

            // recursive case: 
            // adds the current node's key to the sum of the keys in the left and right subtrees
            return root.getKey() + sum(root.getLeft()) + sum(root.getRight());

        }

    }

    /**
     * Method that returns the kth biggest element in the BST
     * @param root  the root of the BST
     * @param k  the kth largest element in the BST
     * @return  the kth largest element in the BST
     * @throws IndexOutOfBoundsException  if k is greater than the number of nodes in the BST
     */
    public Node kthBiggest(Node root, int k) throws IndexOutOfBoundsException {        
        
        // check to see if the node requested exists in the BST
        if (k > getNodeCount() + 1) {
            throw new IndexOutOfBoundsException();
        }

        // create a List that will store all of the Nodes in the BST
        List<Node> elements = new ArrayList<>();

        // perform an inorder traversal of the BST
        inorderRec(root, elements);

        // return the kth largest element in the List
        return elements.get(getNodeCount() - k + 1);

    }

    /**
     * Recursive method that performs an inorder traversal of the BST and stores the Nodes in a List
     * @param root  the root of the BST
     * @param elements  the List that will store the Nodes in the BST
     */
    private void inorderRec(Node root, List<Node> elements) {
        
        // base case
        if (root == null) {
            return;
        }

        // recursive case:

        // traverses the left subtree of a node
        inorderRec(root.getLeft(), elements);
        
        // adds the current node to the List
        elements.add(root);

        // traverses the right subtree of a node
        inorderRec(root.getRight(), elements);

    }    

}
